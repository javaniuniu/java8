package com.javaniuniu.common;

public enum CodeEnum {
    SUCCESS(200),
    ERROR(0);

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}