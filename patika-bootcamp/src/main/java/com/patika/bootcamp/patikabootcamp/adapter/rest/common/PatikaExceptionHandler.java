package com.patika.bootcamp.patikabootcamp.adapter.rest.common;

import com.patika.bootcamp.patikabootcamp.domain.exception.ExceptionType;
import com.patika.bootcamp.patikabootcamp.domain.exception.PatikaDataNotFoundException;
import com.patika.bootcamp.patikabootcamp.domain.exception.PatikaValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatikaExceptionHandler {

    @ExceptionHandler(PatikaDataNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResponse handleDataNotFoundException(PatikaDataNotFoundException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }

    @ExceptionHandler(PatikaValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleValidationException(PatikaValidationException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception e) {
        return new ExceptionResponse(ExceptionType.GENERIC_EXCEPTION, e.getMessage());
    }
}
