package com.service.currency_service.infrastructure.adapter.in.rest;

import com.service.currency_service.application.dto.CountryCurrencyDTO;
import com.service.currency_service.application.port.in.GetCountriesByCurrencyUseCase;
import com.service.currency_service.application.port.in.GetCurrencyByCountryUseCase;
import com.service.currency_service.infrastructure.adapter.in.mapper.CountryCurrencyMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CountryCurrencyController {

    private final GetCurrencyByCountryUseCase getCurrencyByCountryUseCase;
    private final GetCountriesByCurrencyUseCase getCountriesByCurrencyUseCase;
    private final CountryCurrencyMapper mapper;

    public CountryCurrencyController(GetCurrencyByCountryUseCase getCurrencyByCountryUseCase,
                                     GetCountriesByCurrencyUseCase getCountriesByCurrencyUseCase,
                                     CountryCurrencyMapper mapper) {
        this.getCurrencyByCountryUseCase = getCurrencyByCountryUseCase;
        this.getCountriesByCurrencyUseCase = getCountriesByCurrencyUseCase;
        this.mapper = mapper;
    }

    @GetMapping("/countries/{isoCode}/currency")
    public ResponseEntity<CountryCurrencyDTO> getCurrencyByCountry(@PathVariable String isoCode) {
        var countryCurrency = getCurrencyByCountryUseCase.getCurrencyByCountry(isoCode);
        return ResponseEntity.ok(mapper.toDTO(countryCurrency));
    }

    @GetMapping("/currencies/{code}/countries")
    public ResponseEntity<List<CountryCurrencyDTO>> getCountriesByCurrency(@PathVariable String code) {
        var countryCurrencies = getCountriesByCurrencyUseCase.getCountriesByCurrency(code);
        return ResponseEntity.ok(mapper.toDTOList(countryCurrencies));
    }

}
