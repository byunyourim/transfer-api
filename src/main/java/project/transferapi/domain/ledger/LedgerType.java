package project.transferapi.domain.ledger;

import project.transferapi.domain.Code;

public enum LedgerType implements Code {
    INTERNAL_TRANSFER("LT01", "내부이체"),
    REVERSAL("LT02", "이체 취소/복구");

    private final String code;
    private final String name;

    LedgerType(String code, String name) {
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
