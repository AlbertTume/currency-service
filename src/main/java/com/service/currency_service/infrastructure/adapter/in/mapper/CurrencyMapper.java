package com.service.currency_service.infrastructure.adapter.in.mapper;

import com.service.currency_service.application.dto.CurrencyDTO;
import com.service.currency_service.domain.model.Currency;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyMapper {

    public CurrencyDTO toDTO(Currency domain) {
        if (domain == null) {
            return null;
        }
        return new CurrencyDTO(domain.getCode(), domain.getName());
    }

    public List<CurrencyDTO> toDTOList(List<Currency> domainList) {
        if (domainList == null) {
            return List.of();
        }
        return domainList.stream()
                .map(this::toDTO)
                .toList();
    }

}
