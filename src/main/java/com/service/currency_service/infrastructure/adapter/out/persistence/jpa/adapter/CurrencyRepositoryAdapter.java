package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.adapter;

import com.service.currency_service.domain.model.Currency;
import com.service.currency_service.domain.repository.CurrencyRepository;
import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.mapper.CurrencyPersistenceMapper;
import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.repository.CurrencyJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CurrencyRepositoryAdapter implements CurrencyRepository {

    private final CurrencyJpaRepository jpaRepository;
    private final CurrencyPersistenceMapper mapper;

    public CurrencyRepositoryAdapter(CurrencyJpaRepository jpaRepository, CurrencyPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Currency> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Currency> findByCode(String code) {
        return jpaRepository.findByCode(code)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByCode(String code) {

        return jpaRepository.existsByCode(code);
    }

}
