package com.service.currency_service.infrastructure.adapter.in.rest;

import com.service.currency_service.application.dto.CurrencyDTO;
import com.service.currency_service.application.port.in.FindCurrencyByCodeUseCase;
import com.service.currency_service.application.port.in.GetAllCurrenciesUseCase;
import com.service.currency_service.infrastructure.adapter.in.mapper.CurrencyMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@CrossOrigin(origins = "*")
public class CurrencyController {

    private final GetAllCurrenciesUseCase getAllCurrenciesUseCase;
    private final FindCurrencyByCodeUseCase findCurrencyByCodeUseCase;
    private final CurrencyMapper mapper;

    public CurrencyController(GetAllCurrenciesUseCase getAllCurrenciesUseCase,
                              FindCurrencyByCodeUseCase findCurrencyByCodeUseCase,
                              CurrencyMapper mapper) {
        this.getAllCurrenciesUseCase = getAllCurrenciesUseCase;
        this.findCurrencyByCodeUseCase = findCurrencyByCodeUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CurrencyDTO>> getAllCurrencies() {
        var currencies = getAllCurrenciesUseCase.getAllCurrencies();
        return ResponseEntity.ok(mapper.toDTOList(currencies));
    }

    @GetMapping("/{code}")
    public ResponseEntity<CurrencyDTO> getCurrencyByCode(@PathVariable String code) {
        var currency = findCurrencyByCodeUseCase.findByCode(code);
        return ResponseEntity.ok(mapper.toDTO(currency));
    }

}
