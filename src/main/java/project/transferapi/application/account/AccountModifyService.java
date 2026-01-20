package project.transferapi.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.application.transfer.TransferCommand;

@Service
@RequiredArgsConstructor
public class AccountModifyService {
    /**
     * 잔액 변경
     * @param command 이체 정보 command
     * @param result 이상탐지결과
     */
    public void modify(TransferCommand command, FraudDetectionResult result) {
        
    }
}
