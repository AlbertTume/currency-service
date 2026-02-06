package com.service.currency_service.infrastructure.adapter.out.persistence.jpa.mapper;

import com.service.currency_service.domain.model.Currency;
import com.service.currency_service.infrastructure.adapter.out.persistence.jpa.entity.CurrencyEntity;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

@Component
public class CurrencyPersistenceMapper {

    public Currency toDomain(CurrencyEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Currency(
                entity.getId(),
                entity.getCode(),
                entity.getName()
        );
    }

    public CurrencyEntity toEntity(Currency domain) {
        if (domain == null) {
            return null;
        }
        CurrencyEntity entity = new CurrencyEntity();
        entity.setId(domain.getId());
        entity.setCode(domain.getCode());
        entity.setName(domain.getName());
        return entity;
    }

}
