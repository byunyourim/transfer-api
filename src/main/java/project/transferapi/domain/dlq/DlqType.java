package project.transferapi.domain.dlq;

import project.transferapi.domain.Code;

public enum DlqType implements Code {
    BUSINESS("DT01", "비즈니스"),
    SYSTEM("DT02", "시스템");

    private final String code;
    private final String name;

    DlqType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return name;
    }
}
