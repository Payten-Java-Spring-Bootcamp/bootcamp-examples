package com.patika.bootcamp.patikabootcamp.domain.exception;

import lombok.Getter;

@Getter
public class PatikaDataNotFoundException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public PatikaDataNotFoundException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public PatikaDataNotFoundException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
