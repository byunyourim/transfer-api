package project.transferapi.domain.fraud;

import project.transferapi.domain.Code;

public enum ActionType implements Code {
    HOLD_TRANSFER("AT01", "이체정지"),
    BLOCK_ACCOUNT("AT02", "계좌중지"),
    RELEASE_HOLD("AT03", "중지해제");

    private final String code;
    private final String name;

    ActionType(String code, String name) {
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
