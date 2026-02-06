package com.service.currency_service.application.service;

import com.service.currency_service.application.port.in.FindCurrencyByCodeUseCase;
import com.service.currency_service.application.port.in.GetAllCurrenciesUseCase;
import com.service.currency_service.domain.exception.CurrencyNotFoundException;
import com.service.currency_service.domain.model.Currency;
import com.service.currency_service.domain.repository.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CurrencyService implements GetAllCurrenciesUseCase, FindCurrencyByCodeUseCase {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency findByCode(String code) {
        return currencyRepository.findByCode(code)
                .orElseThrow(() -> new CurrencyNotFoundException(code));
    }

}
