package com.service.currency_service.application.service;

import com.service.currency_service.application.port.in.GetCountriesByCurrencyUseCase;
import com.service.currency_service.application.port.in.GetCurrencyByCountryUseCase;
import com.service.currency_service.domain.exception.CurrencyNotFoundException;
import com.service.currency_service.domain.model.CountryCurrency;
import com.service.currency_service.domain.repository.CountryCurrencyQueryRepository;
import com.service.currency_service.domain.repository.CountryCurrencyRepository;
import com.service.currency_service.domain.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CountryCurrencyService implements GetCurrencyByCountryUseCase, GetCountriesByCurrencyUseCase {

    private static final Logger log = LoggerFactory.getLogger(CountryCurrencyService.class);

    private final CountryCurrencyRepository countryCurrencyRepository;
    private final CountryCurrencyQueryRepository countryCurrencyQueryRepository;
    private final CurrencyRepository currencyRepository;

    public CountryCurrencyService(CountryCurrencyRepository countryCurrencyRepository,
                                  CountryCurrencyQueryRepository countryCurrencyQueryRepository,
                                  CurrencyRepository currencyRepository) {
        this.countryCurrencyRepository = countryCurrencyRepository;
        this.countryCurrencyQueryRepository = countryCurrencyQueryRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public CountryCurrency getCurrencyByCountry(String countryIsoCode) {
        log.debug("Getting currency for country: {}", countryIsoCode);

        return countryCurrencyRepository.findByCountryIsoCode(countryIsoCode)
                .orElseThrow(() -> new CurrencyNotFoundException(
                        String.format("No currency found for country: %s", countryIsoCode)
                ));
    }

    @Override
    public List<CountryCurrency> getCountriesByCurrency(String currencyCode) {
        log.debug("Getting countries that use currency: {}", currencyCode);

        if (!currencyRepository.existsByCode(currencyCode)) {
            throw new CurrencyNotFoundException(currencyCode);
        }

        return countryCurrencyQueryRepository.findCountriesByCurrency(currencyCode);
    }

}
