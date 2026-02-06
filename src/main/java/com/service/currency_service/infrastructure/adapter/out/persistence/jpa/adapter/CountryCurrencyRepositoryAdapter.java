package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.adapter;

import com.service.currency_service.domain.model.CountryCurrency;
import com.service.currency_service.domain.repository.CountryCurrencyRepository;
import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.mapper.CountryCurrencyPersistenceMapper;
import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.repository.CountryCurrencyJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryCurrencyRepositoryAdapter implements CountryCurrencyRepository {

    private final CountryCurrencyJpaRepository jpaRepository;
    private final CountryCurrencyPersistenceMapper mapper;

    public CountryCurrencyRepositoryAdapter(CountryCurrencyJpaRepository jpaRepository, CountryCurrencyPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<CountryCurrency> findByCountryIsoCode(String countryIsoCode) {
        return jpaRepository.findByCountryIsoCodeAndIsPrimaryTrue(countryIsoCode)
                .map(mapper::toDomain);
    }

    @Override
    public List<CountryCurrency> findAllByCountryIsoCode(String countryIsoCode) {
        return jpaRepository.findAllByCountryIsoCode(countryIsoCode)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCountryIsoCodeAndCurrencyCode (String countryIsoCode, String currencyCode) {
        return jpaRepository.existsByCountryIsoCodeAndCurrencyCode(countryIsoCode, currencyCode);
    }

}
