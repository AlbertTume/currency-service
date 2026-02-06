package com.service.currency_service.application.dto;

import java.util.List;

public class CountryCurrencyResponseDTO {

    private String currencyCode;
    private String currencyName;
    private List<CountryEntity> countries;

    public CountryCurrencyResponseDTO() {}

    public CountryCurrencyResponseDTO(String currencyCode,
                                      String currencyName,
                                      List<CountryEntity> countries) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.countries = countries;
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

    public List<CountryEntity> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryEntity> countries) {
        this.countries = countries;
    }

    public static class CountryEntity {
        private String countryIsoCode;
        private boolean isPrimary;

        public CountryEntity() {}

        public CountryEntity(String countryIsoCode, boolean isPrimary) {
            this.countryIsoCode = countryIsoCode;
            this.isPrimary = isPrimary;
        }

        public String getCountryIsoCode() {
            return countryIsoCode;
        }

        public void setCountryIsoCode(String countryIsoCode) {
            this.countryIsoCode = countryIsoCode;
        }

        public boolean getIsPrimary(){
            return isPrimary;
        }

        public void setIsPrimary(boolean isPrimary) {
            this.isPrimary = isPrimary;
        }
    }

}
