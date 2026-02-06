package com.service.currency_service.application.port.in;

import com.service.currency_service.domain.model.CountryCurrency;

import java.util.List;

/**
 * Puerto de entrada para obtener países que usan una moneda
 * EndPoint: [GET] /api/v1/currencies/{code}/countries
 * Implementación: Usa stored procedure via JDBC
 */
public interface GetCountriesByCurrencyUseCase {

    public List<CountryCurrency> getCountriesByCurrency(String currencyCode);

}
