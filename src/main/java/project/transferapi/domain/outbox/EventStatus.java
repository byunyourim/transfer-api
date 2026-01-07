package project.transferapi.domain.outbox;

import project.transferapi.domain.Code;

public enum EventStatus implements Code {
    PENDING("ES01", "발행대기"),
    SENT("ES02", "발행완료"),
    FAILED("ES03", "발행실패");

    private final String code;
    private final String name;

    EventStatus(String code, String name) {
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
