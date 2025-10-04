package com.patryk.exchange_api.controller;

import com.patryk.exchange_api.model.ConvertRequest;
import com.patryk.exchange_api.model.ConvertResult;
import com.patryk.exchange_api.model.Currencies;
import com.patryk.exchange_api.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @GetMapping
    public Currencies getAllCurrencies() {
        return service.getAllCurrencies();
    }

    @GetMapping("/convert")
    public ConvertResult convert(@Valid ConvertRequest convertRequest) {
        return service.convert(convertRequest);
    }
}