package project.transferapi.domain;

public enum ChannelType implements Code {
    MOBILE("CH01", "모바일"),
    BRANCH("CH02", "영업점");

    private final String code;
    private final String name;

    ChannelType(String code, String name) {
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
