package com.service.currency_service.domain.exception;

public class CurrencyNotFoundException extends RuntimeException {

    private final String code;

    public CurrencyNotFoundException(String code) {
        super(String.format("Currency with code %s not found", code));
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
