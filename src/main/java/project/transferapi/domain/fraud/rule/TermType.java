package project.transferapi.domain.fraud.rule;

import project.transferapi.domain.Code;

public enum TermType implements Code {
    MINUTE("TT01", "분"),
    HOURS("TT02", "시간"),
    PER("TT03", "회"),
    DAY("TT04", "일"),
    WEEK("TT05", "주"),
    MONTH("TT06", "월");

    private final String code;
    private final String name;

    TermType(String code, String name) {
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
