package project.transferapi.domain.ledger;

import project.transferapi.domain.Code;

public enum TransferDirection implements Code {
    IN("TD01", "입금"),
    OUT("TD02", "출금");

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