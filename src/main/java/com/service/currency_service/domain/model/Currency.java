package com.service.currency_service.domain.model;

import java.util.Objects;

public class Currency {

    private Integer id;
    private String code;
    private String name;

    //Constructores [1. Empty | 2. To create | 3. Full]
    public Currency() {}

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Currency(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                "}";
    }
}
