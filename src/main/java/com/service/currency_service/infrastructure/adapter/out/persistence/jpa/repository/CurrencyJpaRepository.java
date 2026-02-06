package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.repository;

import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyJpaRepository extends JpaRepository<CurrencyEntity, Integer> {

    public Optional<CurrencyEntity> findByCode(String code);
    public boolean existsByCode(String code);

}
