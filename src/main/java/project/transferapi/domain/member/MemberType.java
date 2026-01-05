package project.transferapi.domain.member;

import project.transferapi.domain.Code;

public enum MemberType implements Code {
    SYSTEM("MT", "관리자");

    private final String code;
    private final String name;

    MemberType(String code, String name) {
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
