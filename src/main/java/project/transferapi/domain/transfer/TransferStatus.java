package project.transferapi.domain.transfer;

import project.transferapi.domain.Code;

public enum TransferStatus implements Code {
    REQUESTED("TS01", "요청"),
    HOLD("TS02", "중지"),
    SUCCESS("TS03", "성공"),
    FAILED("TS04", "실패"),
    CANCELED("TS05", "취소");

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
