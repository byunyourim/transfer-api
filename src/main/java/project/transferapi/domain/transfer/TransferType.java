package project.transferapi.domain.transfer;

import project.transferapi.domain.Code;

public enum TransferType implements Code {
    INTERNAL("TT01", "내부이체"),
    ONCHAIN("TT02", "온체인거래");

    private final String code;
    private final String name;

    TransferType(String code, String name) {
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
