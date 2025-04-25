package com.pablo.api.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pablo.api.entity.dto.ErrorDTO;
import com.pablo.api.exception.CreditoNotFoundException;

@ControllerAdvice
public class CreditoNotFoundExceptionHandler extends RuntimeException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(CreditoNotFoundException.class)
    public ErrorDTO handler(CreditoNotFoundException e) {
        return new ErrorDTO(e.getStatus(), e.getMessage());
    }

}