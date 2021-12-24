package com.origin.financial.insurance.adapters.web.exception;

public class BadRequestResourceException extends RuntimeException {
    public BadRequestResourceException(String message) {
        super(message);
    }
}