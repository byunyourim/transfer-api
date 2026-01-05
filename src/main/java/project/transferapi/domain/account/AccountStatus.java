package project.transferapi.domain.account;

import project.transferapi.domain.Code;

public enum AccountStatus implements Code {
    ACTIVE( "AS01", "정상" ),
    SUSPENDED( "AS02", "일시 정지" ),
    TERMINATED( "AS03", "해지");

    private final String code;
    private final String name;

    AccountStatus( String code, String name ) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
