package com.pablo.api.exception;

import lombok.Getter;

@Getter
public class CreditoNotFoundException extends RuntimeException {

    private final int status;

    public CreditoNotFoundException(int status, String message) {
        super(message);
        this.status = status;
    }

}
