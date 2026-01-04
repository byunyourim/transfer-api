package project.transferapi.domain.account;

import project.transferapi.domain.Code;

public enum AccountStatus implements Code {
    ACTIVE( "AS01", "정상" ) {
        @Override
        public boolean changeable(AccountStatus status) {
            return status == SUSPENDED || status == TERMINATED;
        }
    },
    SUSPENDED( "AS02", "일시 정지" ) {
        @Override
        public boolean changeable(AccountStatus status) {
            return status == TERMINATED;
        }
    },
    TERMINATED( "AS03", "해지") {
        @Override
        public boolean changeable(AccountStatus status) {
            return false;
        }
    };

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

    public abstract boolean changeable(AccountStatus status);
}
