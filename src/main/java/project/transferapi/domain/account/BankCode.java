package project.transferapi.domain.account;

import project.transferapi.domain.Code;

public enum BankCode implements Code {
    KB("004", "국민은행"),
    SHINHAN("088", "신한은행"),
    WOORI("020", "우리은행"),
    HANA("081", "하나은행"),
    NH("011", "농협은행"),
    IBK("003", "기업은행"),
    KAKAO("090", "카카오뱅크"),
    TOSS("092", "토스뱅크"),
    SC("023", "SC제일은행"),
    CITY("027", "씨티은행"),
    BUSAN("032", "부산은행"),
    DAEGU("031", "대구은행"),
    GWANGJU("034", "광주은행"),
    JEONBUK("037", "전북은행"),
    JEJU("035", "제주은행");

    private final String code;
    private final String name;

    BankCode(String code, String name) {
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
