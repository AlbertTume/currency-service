package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.mapper;

import com.service.currency_service.domain.model.CountryCurrency;
import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.entity.CountryCurrencyEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryCurrencyPersistenceMapper {

    public CountryCurrency toDomain(CountryCurrencyEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CountryCurrency(
                entity.getId(),
                entity.getCountryIsoCode(),
                entity.getCurrency().getCode(),
                entity.getCurrency().getName(),
                entity.isPrimary()
        );
    }
}
