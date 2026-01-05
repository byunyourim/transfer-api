package project.transferapi.domain.user;


import project.transferapi.domain.Code;

public enum UserStatus implements Code {
    ACTIVE("US01", "활성화"),
    SUSPENDED("US02", "거래정지"),
    DORMANT("US03", "휴면"),
    WITHDRAWN("US04", "탈퇴"),
    BLOCKED("US05", "금융사고차단");

    private final String code;
    private final String name;

    UserStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }


    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
