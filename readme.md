# 거래 / 이상탐지 시스템 

---
## 테이블 
### 유저 (User)
| 컬럼명 | 설명 | 비고 |
|---|---|---|
| id | 유저 ID | PK |
| username | 유저명 |  |
| status | 유저 상태 | ACTIVE / DORMANT / WITHDRAWN |
| created_at | 등록일시 |  |
| updated_at | 수정일시 |  |

### 운영자 (Admin)
| 컬럼명 | 설명 | 비고             |
|---|---|----------------|
| id | 운영자 ID | PK             |
| role | 권한 | SYSTEM / ADMIN |
| created_at | 등록일시 |                |
| updated_at | 수정일시 |                |

### 계좌 (Account)
| 컬럼명 | 설명 | 비고 |
|---|---|---|
| id | 계좌 ID | PK |
| user_id | 소유자 유저 ID | FK |
| balance | 잔액 | >= 0 (실시간 기준 잔액) |
| status | 계좌 상태 | ACTIVE / DORMANT / SUSPENDED |
| daily_transfer_count_limit | 1일 이체 횟수 한도 | >= 0 AND < 1000 |
| daily_transfer_amount_limit | 하루 이체 금액 한도 | < 100000000 |
| created_at | 등록일시 |  |
| updated_at | 수정일시 |  |
- balance는 최종 정합성의 기준

### 이체 (Transfer)
| 컬럼명 | 설명 | 비고                                                 |
|---|---|----------------------------------------------------|
| id | 이체 ID | PK                                                 |
| from_account_id | 출금 계좌 ID | FK                                                 |
| to_account_id | 입금 계좌 ID | FK                                                 |
| amount | 이체 금액 | > 0                                                |
| direction | 입/출금 구분 | IN/OUT                                |
| status | 이체 상태 | REQUESTED / COMPLETED / FAILED                     |
| failure_reason | 실패 사유 | INSUFFICIENT_BALANCE / FRAUD_BLOCKED / SYSTEM_ERROR |
| requested_at | 이체 요청 일시 |                                                    |
| completed_at | 이체 완료 일시 | status = COMPLETED                            |

### 원장 (Ledger)
| 컬럼명 | 설명 | 비고 |
|---|---|--|
| id | 원장 ID | PK |
| transfer_id | 이체 ID | FK |
| account_id | 계좌 ID | FK |
| before_balance | 변경 전 금액 | 기록 시점 기준 |
| after_balance | 변경 후 금액 | 기록 시점 기준 |
| amount | 변경 금액 |  |
| type | 원장 타입 | TRANSFER_IN / TRANSFER_OUT / FEE |
| created_at | 등록일시 |  |

### 이상탐지 룰 (FraudRule)
| 컬럼명 | 설명 | 비고                        |
|---|---|---------------------------|
| id | 룰 ID | PK                        |
| name | 룰 이름 |                           |
| rule_type | 룰 유형 | AMOUNT / COUNT / VELOCITY |
| threshold | 임계값 | 단일 기준                     |
| min_value | 구간 최소값 | 범위 기준                     |
| max_value | 구간 최대값 | 범위 기준                     |
| risk_level | 위험도 | LOW / MEDIUM / HIGH       |
| enabled | 사용 여부 | true / false              |
| created_at | 등록일시 |                           |
| updated_at | 수정일시 |                           |

### 탐지 이력 (FraudDetectionHistory)
| 컬럼명 | 설명 | 비고                   |
|---|---|----------------------|
| id | 탐지 이력 ID | PK                   |
| transfer_id | 이체 ID | FK                   |
| rule_id | 적용된 룰 ID | FK                   |
| account_id | 계좌 ID | FK                   |
| actual_value | 실제 측정값 | 탐지 시점 기준             |
| threshold_value | 기준값 | threshold or min/max |
| detection_status | 탐지 상태 | DETECTED / PASSED    |
| detected_at | 탐지 시각 |                      |
- 목적: 부정거래 탐지 결과 이력 저장
- 어떤 이체에서 이상이 탐지되었는지 기록
- 어떤 룰에 걸렸는지 (ruleId)
- 실제값(actualValue)과 임계값(threshold) 저장
- 위험도(severityType) 저장
- 이상이 탐지된 경우에만 기록
- 탐지 결과 수정 불가


### 조치 이력 (FraudActionHistory)
| 컬럼명 | 설명        | 비고                     |
|---|-----------|------------------------|
| id | 조치 이력 ID  | PK                     |
| detection_history_id | 탐지 이력 ID  | FK                     |
| action_type | 조치 유형     | BLOCK / HOLD / STEP_UP |
| admin_id | 운영자 ID | FK                     |
| processed_at | 처리일시      | 실제 조치 시점               |
| created_at | 등록일시      |                        |
| updated_at | 수정일시      |                        |
- 목적: 탐지된 이상 거래에 대한 조치 이력 저장
- 탐지이력과 거의 동일한 구조
- 추가로 detectionStatusType 필드가 있음 (조치 상태 관리용)
- 탐지 후 실시간/사후 조치를 취한 내역 저장
- 하나의 탐지 결과에 **여러 조치 이력**이 생길 수 있음

### 아웃박스 이벤트 큐 (TransferOutbox)
| 컬럼명 | 설명 | 비고 |
|---|---|---|
| id | 이벤트 ID | PK |
| transfer_id | 이체 ID | FK |
| event_type | 이벤트 종류 | TransferRequested / TransferCompleted / FraudEvaluated |
| payload | 이벤트 데이터 | JSON (불변) |
| status | 상태 | PENDING / SENT / FAILED |
| created_at | 생성일시 |  |
| published_at | 발행일시 | nullable |
  목적: 이벤트 기반 아키텍처의 Outbox Pattern 구현
- 이체가 생성되면 TransferCreatedEvent를 외부 시스템에 발행하기 위한 임시 저장소
- 데이터 정합성 보장: 이체 데이터와 이벤트 발행을 동일 트랜잭션에서 처리
- 메시지 큐나 다른 마이크로서비스에 이벤트 전달 보장
- 상태 관리: PENDING → SENT/FAILED
- 재시도 로직 포함 (최대 3회)
- Outbox 는 **트랜잭션 내에서 저장 후 비동기 발행**
- payload 수정 X

### 실패 이벤트 (DeadLetterEvent)
| 컬럼명 | 설명 | 비고 |
|---|---|---|
| id | 실패 이벤트 ID | PK |
| transfer_id | 이체 ID | FK |
| failure_type | 실패 유형 | BUSINESS / SYSTEM |
| error_code | 에러 코드 |  |
| error_message | 에러 메시지 | 원본 메시지 |
| retryable | 재시도 가능 여부 | true / false |
| created_at | 등록일시 |  |
- DLQ 는 **실패 후 운영자가 재판단 하기 위한 데이터**
- 자동 수정/삭제 불가

---

### 💡 Outbox Pattern
데이터 저장과 이벤트 발행의 원자성을 보장하는 패턴

1. 이체 데이터 저장 + 아웃박스에 이벤트 저장 → 같은 트랜잭션
2. 별도 배치/스케줄러가 아웃박스를 폴링하여 메시지 큐에 발행
3. 발행 성공 시 SENT 상태로 변경
