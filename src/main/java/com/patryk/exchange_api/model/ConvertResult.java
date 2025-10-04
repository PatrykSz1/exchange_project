package com.patryk.exchange_api.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvertResult {

    private boolean success;
    private Query query;
    private Info info;
    private String date;
    private BigDecimal result;
}

