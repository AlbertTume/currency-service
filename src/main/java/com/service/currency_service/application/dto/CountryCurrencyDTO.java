package com.service.currency_service.application.dto;

public class CountryCurrencyDTO {

    private String countryIsoCode;
    private String currencyCode;
    private String currencyName;
    private boolean isPrimary;

    public CountryCurrencyDTO() {}

    public CountryCurrencyDTO(String countryIsoCode, String currencyCode, String currencyName, boolean isPrimary) {
        this.countryIsoCode = countryIsoCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.isPrimary = isPrimary;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

}
