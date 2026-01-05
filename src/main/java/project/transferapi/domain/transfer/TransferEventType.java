package project.transferapi.domain.transfer;

import project.transferapi.domain.Code;

public enum TransferEventType implements Code {
    REQUESTED("TT01", "이체요청"),
    RISK_DECIDED_ALLOW("TT02", "이상탐지완료"),
    RISK_DECIDED_BLOCK("TT03", "이상탐지차단"),
    LEDGER_POSTED("TT04", "원장반영"),
    TRANSFER_COMPLETED("TT05", "이체완료"),
    TRANSFER_FAILED("TT06", "이체실패");

    private final String code;
    private final String name;

    TransferEventType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
