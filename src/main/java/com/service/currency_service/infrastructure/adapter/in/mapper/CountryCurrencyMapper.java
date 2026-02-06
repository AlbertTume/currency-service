package com.service.currency_service.infrastructure.adapter.in.mapper;

import com.service.currency_service.application.dto.CountryCurrencyDTO;
import com.service.currency_service.domain.model.CountryCurrency;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryCurrencyMapper {

    public CountryCurrencyDTO toDTO(CountryCurrency domain) {
        if (domain == null) {
            return null;
        }
        return new CountryCurrencyDTO(
                domain.getCountryIsoCode(),
                domain.getCurrencyCode(),
                domain.getCurrencyName(),
                domain.isPrimary()
        );
    }

    public List<CountryCurrencyDTO> toDTOList(List<CountryCurrency> domainList) {
        if (domainList == null) {
            return List.of();
        }
        return domainList.stream()
                .map(this::toDTO)
                .toList();
    }

}
