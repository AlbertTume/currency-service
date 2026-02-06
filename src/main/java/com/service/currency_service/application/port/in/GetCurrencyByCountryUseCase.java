package com.service.currency_service.application.port.in;

import com.service.currency_service.domain.model.CountryCurrency;

/**
 * Puerto de entrada para obtener la moneda de un país
 * EndPoint: [GET] /api/v1/countries/{isoCode}/currency
 */
public interface GetCurrencyByCountryUseCase {

    public CountryCurrency getCurrencyByCountry(String countryIsoCode);

}
