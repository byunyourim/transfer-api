package project.transferapi.domain.transfer;

import project.transferapi.domain.Code;

public enum TransferStatus implements Code {
    REQUESTED("TS01", "이체요청"),
    HOLD("TS02", "일시중지"),
    COMPLETED("TS03", "완료"),
    CANCELED("TS04", "취소");

    private final String code;
    private final String name;

    TransferStatus(String code, String name) {
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
