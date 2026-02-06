package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.repository;

import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.entity.CountryCurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryCurrencyJpaRepository extends JpaRepository<CountryCurrencyEntity, Integer> {

    public Optional<CountryCurrencyEntity> findByCountryIsoCodeAndIsPrimaryTrue(String countryIsoCode);
    public List<CountryCurrencyEntity> findAllByCountryIsoCode(String countryIsoCode);
    public boolean existsByCountryIsoCodeAndCurrencyCode(String countryIsoCode, String currencyCode);

}
