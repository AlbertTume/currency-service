package com.service.currency_service.application.port.out;

/**
 * Puerto de salida para comunicación con Country Service
 * Implementado por: HTTP Client Adapter
 */
public interface CountryServiceClient {

    /**
     * Valida si un país existe en el Country Service
     * @param countryIsoCode Código ISO-2 del país (PE, US, DE, etc.)
     * @return true si el país existe, false en caso contrario
     */
    public boolean validateCountryExists(String countryIsoCode);
}
