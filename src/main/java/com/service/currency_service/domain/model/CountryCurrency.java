package com.service.currency_service.domain.model;

import java.util.Objects;

public class CountryCurrency {

    private Integer id;
    private String countryIsoCode;
    private String currencyCode;
    private String currencyName;
    private boolean isPrimary;

    //Constructores [1. Empty | 2. To create | 3. Full]
    public CountryCurrency() {}

    public CountryCurrency(String countryIsoCode, String currencyCode, String currencyName, boolean isPrimary) {
        this.countryIsoCode = countryIsoCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.isPrimary = isPrimary;
    }

    public CountryCurrency(Integer id, String countryIsoCode, String currencyCode, String currencyName, boolean isPrimary) {
        this.id = id;
        this.countryIsoCode = countryIsoCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.isPrimary = isPrimary;
    }

    public Integer getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CountryCurrency that = (CountryCurrency) o;
        return Objects.equals(countryIsoCode, that.countryIsoCode) && Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryIsoCode, currencyCode);
    }

    @Override
    public String toString() {
        return "CountryCurrency{" +
                "id=" + id +
                ", countryIsoCode='" + countryIsoCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
