package com.patryk.exchange_api.model;

import com.patryk.exchange_api.validation.SupportedCurrency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConvertRequest {

    @SupportedCurrency
    private String from;

    @SupportedCurrency
    private String to;

    private BigDecimal amount;
}
