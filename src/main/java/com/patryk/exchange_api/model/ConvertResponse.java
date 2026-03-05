package com.patryk.exchange_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class ConvertResponse {

    private final String from;
    private final String to;
    private final BigDecimal amount;
    private final BigDecimal result;
    private final String date;
}

