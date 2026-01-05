## 테이블 
### tb_user 유저
| 컬럼명        | 한글명    | 타입           | 제약       |
| ---------- | ------ | ------------ | -------- |
| user_id    | 사용자 ID | BIGINT       | PK       |
| name       | 사용자 이름 | VARCHAR(100) | NOT NULL |
| status     | 사용자 상태 | USER_STATUS  | NOT NULL |
| created_at | 생성일시   | TIMESTAMP    | NOT NULL |



### tb_member 운영자
| 컬럼명 | 타입             | 제약                |
|--| -------------- | ----------------- |
| member_id | BIGINT       | PK       |
| member_type | BIGINT       | PK       |
| created_at  | TIMESTAMP    | NOT NULL |
| modified_at | TIMESTAMP    | NOT NULL |

### tb_account 계좌
| 컬럼명         | 한글명    | 타입             | 제약                |
|-------------|--------| -------------- | ----------------- |
| account_id  | 계좌 ID  | BIGINT         | PK                |
| user_id     | 사용자 ID | BIGINT         | FK → user.user_id |
| balance     | 잔액     | DECIMAL(15,2)  | NOT NULL          |
| status      | 계좌 상태  | ACCOUNT_STATUS | NOT NULL          |
| created_at  | 생성일시   | TIMESTAMP      | NOT NULL          |
| modified_at | 수정일시   | TIMESTAMP      | NOT NULL          |


### tb_account_history 계좌 이력
| 컬럼명             | 한글명   | 타입             | 제약                      |
| --------------- | ----- | -------------- | ----------------------- |
| history_id      | 이력 ID | BIGINT         | PK                      |
| account_id      | 계좌 ID | BIGINT         | FK → account.account_id |
| previous_status | 이전 상태 | ACCOUNT_STATUS | NOT NULL                |
| current_status  | 변경 상태 | ACCOUNT_STATUS | NOT NULL                |
| reason          | 변경 사유 | VARCHAR(255)   | NOT NULL                |
| changed_at      | 변경일시  | TIMESTAMP      | NOT NULL                |



### tb_transfer 이체
| 컬럼명             | 한글명      | 타입              | 제약                      |
| --------------- | -------- | --------------- | ----------------------- |
| transfer_id     | 이체 ID    | BIGINT          | PK                      |
| from_account_id | 출금 계좌 ID | BIGINT          | FK → account.account_id |
| to_account_id   | 입금 계좌 ID | BIGINT          | FK → account.account_id |
| amount          | 이체 금액    | DECIMAL(15,2)   | NOT NULL                |
| request_at      | 요청 일시    | TIMESTAMP       | NOT NULL                |
| transfer_type   | 이체 유형    | TRANSFER_TYPE   | NOT NULL                |
| status          | 이체 상태    | TRANSFER_STATUS | NOT NULL                |




### tb_ledger 원장
| 컬럼명            | 한글명     | 타입            | 제약                        |
| -------------- | ------- | ------------- | ------------------------- |
| ledger_id      | 원장 ID   | BIGINT        | PK                        |
| account_id     | 계좌 ID   | BIGINT        | FK → account.account_id   |
| delta_amount   | 증감 금액   | DECIMAL(15,2) | NOT NULL                  |
| before_balance | 변경 전 잔액 | DECIMAL(15,2) | NOT NULL                  |
| after_balance  | 변경 후 잔액 | DECIMAL(15,2) | NOT NULL                  |
| reason         | 변경 사유   | LEDGER_REASON | NOT NULL                  |
| ref_id         | 참조 ID   | BIGINT        | FK → transfer.transfer_id |
| created_at     | 생성일시    | TIMESTAMP     | NOT NULL                  |


### tb_transfer_event 이체 이력 
| 컬럼명         | 한글명    | 타입                  | 제약                        |
| ----------- | ------ | ------------------- | ------------------------- |
| event_id    | 이벤트 ID | BIGINT              | PK                        |
| transfer_id | 이체 ID  | BIGINT              | FK → transfer.transfer_id |
| account_id  | 계좌 ID  | BIGINT              | FK → account.account_id   |
| amount      | 이체 금액  | DECIMAL(15,2)       | NOT NULL                  |
| event_type  | 이벤트 유형 | TRANSFER_EVENT_TYPE | NOT NULL                  |
| occurred_at | 발생 일시  | TIMESTAMP           | NOT NULL                  |



### tb_transfer_fraud_rule 이상 탐지 룰
| 컬럼명         | 한글명   | 타입              | 제약       |
| ----------- | ----- | --------------- | -------- |
| rule_id     | 룰 ID  | BIGINT          | PK       |
| name        | 룰 이름  | VARCHAR(100)    | NOT NULL |
| type        | 룰 유형  | FRAUD_RULE_TYPE | NOT NULL |
| threshold   | 임계값   | DECIMAL(15,2)   | NOT NULL |
| time_window | 시간 구간 | INTERVAL        | NULL     |
| severity    | 위험도   | FRAUD_SEVERITY  | NOT NULL |
| enabled     | 활성 여부 | BOOLEAN         | NOT NULL |


### tb_transfer_fraud_detection 탐지 결과
| 컬럼명          | 한글명    | 타입                     | 제약                               |
| ------------ | ------ | ---------------------- | -------------------------------- |
| detection_id | 탐지 ID  | BIGINT                 | PK                               |
| event_id     | 이벤트 ID | BIGINT                 | FK → transfer_event.event_id     |
| rule_id      | 룰 ID   | BIGINT                 | FK → transfer_fraud_rule.rule_id |
| account_id   | 계좌 ID  | BIGINT                 | FK → account.account_id          |
| detected_at  | 탐지 일시  | TIMESTAMP              | NOT NULL                         |
| actual_value | 실제 값   | DECIMAL(15,2)          | NOT NULL                         |
| threshold    | 기준 값   | DECIMAL(15,2)          | NOT NULL                         |
| severity     | 위험도    | FRAUD_SEVERITY         | NOT NULL                         |
| status       | 탐지 상태  | FRAUD_DETECTION_STATUS | NOT NULL                         |


### tb_transfer_fraud_action 조치 이력
| 컬럼명          | 한글명   | 타입                | 제약                                         |
| ------------ | ----- | ----------------- | ------------------------------------------ |
| action_id    | 조치 ID | BIGINT            | PK                                         |
| detection_id | 탐지 ID | BIGINT            | FK → transfer_fraud_detection.detection_id |
| action_type  | 조치 유형 | FRAUD_ACTION_TYPE | NOT NULL                                   |
| processed_at | 처리 일시 | TIMESTAMP         | NOT NULL                                   |




