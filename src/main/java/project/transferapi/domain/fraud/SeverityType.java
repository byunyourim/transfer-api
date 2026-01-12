package project.transferapi.domain.fraud;

import project.transferapi.domain.Code;

public enum SeverityType implements Code {
    LOW("ST01", "낮음"),
    MEDIUM("ST02", "보통"),
    HIGH("ST03", "높음");     // (위험도: 높음)인 경우 이체 차단

    private final String code;
    private final String name;

    SeverityType(String code, String name) {
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