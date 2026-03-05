package com.patryk.exchange_api.validation;

import com.patryk.exchange_api.service.CurrencyService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupportedCurrencyValidator implements ConstraintValidator<SupportedCurrency, String> {

    private final CurrencyService currencyService;

    @Override
    public boolean isValid(String currencySymbol, ConstraintValidatorContext constraintValidatorContext) {
        return currencyService.getAllCurrencies().getSymbols().containsKey(currencySymbol);
    }
}
