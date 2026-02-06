package com.service.currency_service.domain.repository;

import com.service.currency_service.domain.model.CountryCurrency;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones CRUD
 * Implementado por: JPA Adapter
 */
public interface CountryCurrencyRepository {

    Optional<CountryCurrency> findByCountryIsoCode(String countryIsoCode);
    List<CountryCurrency> findAllByCountryIsoCode(String countryIsoCode);
    boolean existsByCountryIsoCodeAndCurrencyCode(String countryIsoCode, String currencyCode);

}
