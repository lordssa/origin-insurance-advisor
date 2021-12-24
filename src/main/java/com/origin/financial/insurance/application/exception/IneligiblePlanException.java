package com.origin.financial.insurance.application.exception;

public class IneligiblePlanException extends RuntimeException {
    public IneligiblePlanException(String message) {
        super(message);
    }
}

