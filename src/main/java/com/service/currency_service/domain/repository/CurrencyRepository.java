package com.service.currency_service.domain.repository;

import com.service.currency_service.domain.model.Currency;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones de consulta/persistencia
 * Implementado por: JPA Adapter
 */
public interface CurrencyRepository {

    Optional<Currency> findByCode(String code);
    List<Currency> findAll();
    boolean existsByCode(String code);

}
