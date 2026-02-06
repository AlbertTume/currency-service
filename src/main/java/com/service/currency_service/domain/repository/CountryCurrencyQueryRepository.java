package com.service.currency_service.domain.repository;

import com.service.currency_service.domain.model.CountryCurrency;

import java.util.List;

/**
 * Puerto de salida para consultas complejas
 * Implementado por: JDBC Adapter
 */
public interface CountryCurrencyQueryRepository {

    /**
     * Obtiene todos los países que usan la misma moneda
     * Usa stored procedure: get_countries_by_currency
     * @param countryIsoCode - Código de la moneda (EUR, USD, PEN, etc.)
     * @return Lista de relaciones país-moneda
     */
    public List<CountryCurrency> findCountriesByCurrency(String countryIsoCode);

}
