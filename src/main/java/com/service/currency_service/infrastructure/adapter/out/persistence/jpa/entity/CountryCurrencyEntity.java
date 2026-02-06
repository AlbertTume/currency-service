package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "country_currencies")
public class CountryCurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_iso_code", nullable = false, unique = true, length = 2)
    private String countryIsoCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_code", referencedColumnName = "code", nullable = false)
    private CurrencyEntity currency ;

    @Column(name = "is_primary")
    private boolean isPrimary;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CountryCurrencyEntity() {}

    public CountryCurrencyEntity(Integer id, String countryIsoCode, CurrencyEntity currency, boolean isPrimary, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.countryIsoCode = countryIsoCode;
        this.currency = currency;
        this.isPrimary = isPrimary;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public CurrencyEntity getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEntity currency) {
        this.currency = currency;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CountryCurrencyEntity that = (CountryCurrencyEntity) o;
        return Objects.equals(countryIsoCode, that.countryIsoCode) &&
                Objects.equals(currency.getCode(), that.currency.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryIsoCode, currency.getCode());
    }

    @Override
    public String toString() {
        return "CountryCurrency{" +
                "id=" + id +
                ", countryIsoCode='" + countryIsoCode + '\'' +
                ", currency='" + (currency != null ? currency.getCode() + " - " +currency.getName() : null) + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }

}
