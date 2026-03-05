package com.patryk.exchange_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiLayerConvertResponse {
    private boolean success;
    private String date;
    private BigDecimal result;
}
