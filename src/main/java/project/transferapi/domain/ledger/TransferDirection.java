package project.transferapi.domain.ledger;

import project.transferapi.domain.Code;

public enum TransferDirection implements Code {
    DEPOSIT("TD01", "입금"),
    WITHDRAW("TD02", "출금");

    private final String code;
    private final String name;

    TransferDirection(String code, String name) {
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