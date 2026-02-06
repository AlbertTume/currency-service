package com.service.currency_service.application.port.in;

import com.service.currency_service.domain.model.Currency;

import java.util.List;

/**
 * Puerto de entrada para obtener todas las monedas
 * EndPoint: [GET] /api/v1/currencies
 */
public interface GetAllCurrenciesUseCase {

    public List<Currency> getAllCurrencies();

}
