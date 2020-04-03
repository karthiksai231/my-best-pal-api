package com.core.mybestpalapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.avalon.framework.ExceptionUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class MyBestPalExceptionHandler extends ResponseEntityExceptionHandler {

    public MyBestPalExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, errorResponse(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, errorResponse(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { DataIntegrityViolationException.class })
    public final ResponseEntity<Object> handleBadRequest(DataIntegrityViolationException ex, WebRequest request) {
        return handleExceptionInternal(ex, errorResponse(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private RestErrorResponse errorResponse(HttpStatus httpStatus, Exception ex) {
        return new RestErrorResponse(httpStatus.value(), ex.getMessage() != null ? ExceptionUtils.getRootCauseMessage(ex) : ex.getClass().getSimpleName());
    }
}
