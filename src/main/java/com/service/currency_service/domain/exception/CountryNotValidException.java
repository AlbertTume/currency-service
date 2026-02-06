package com.service.currency_service.domain.exception;

public class CountryNotValidException extends RuntimeException {

    private final String countryIsoCode;

    public CountryNotValidException(String countryIsoCode) {
        super(String.format("Country code %s is not valid", countryIsoCode));
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }
}
