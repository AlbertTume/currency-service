package com.service.currency_service.application.port.in;

import com.service.currency_service.domain.model.Currency;

/**
 * Puerto de entrada para buscar una moneda por código
 * EndPoint: [GET] /api/v1/currencies/{code}
 */
public interface FindCurrencyByCodeUseCase {

    public Currency findByCode(String code);

}
