package project.transferapi.domain.fraud;

import project.transferapi.domain.Code;

public enum DetectionStatusType implements Code {
    DETECTED("DT01", "탐지됨"),
    CONFIRMED("DT02", "이상확정"),
    CLEARED("DT03", "정상처리");

    private final String code;
    private final String name;

    DetectionStatusType(String code, String name) {
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
