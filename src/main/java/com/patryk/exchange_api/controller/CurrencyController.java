package com.patryk.exchange_api.controller;

import com.patryk.exchange_api.model.ConvertRequest;
import com.patryk.exchange_api.model.ConvertResponse;
import com.patryk.exchange_api.model.Currencies;
import com.patryk.exchange_api.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @GetMapping
    public ResponseEntity<Currencies> getAllCurrencies() {
        return new ResponseEntity<>(service.getAllCurrencies(), HttpStatus.OK);
    }

    @GetMapping("/convert")
    public ResponseEntity<ConvertResponse> convert(@Valid ConvertRequest convertRequest) {
        return new ResponseEntity<>(service.convert(convertRequest), HttpStatus.OK);
    }
}