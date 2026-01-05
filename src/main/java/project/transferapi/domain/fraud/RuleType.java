package project.transferapi.domain.fraud;

import project.transferapi.domain.Code;

public enum RuleType implements Code {
    AMOUNT("RT01", "금액"),
    COUNT("RT02", "횟수"),
    VELOCITY("RT03", "속도");

    private final String code;
    private final String name;

    RuleType(String code, String name) {
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
