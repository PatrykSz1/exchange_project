package com.patryk.exchange_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Locale;

@Data
public class ConvertRequest {

    @NotBlank
    @Size(min = 3, max = 3)
    private String from;

    @NotBlank
    @Size(min = 3, max = 3)
    private String to;

    @NotNull
    @Positive
    private BigDecimal amount;

    public void setFrom(String from) {
        this.from = normalize(from);
    }

    public void setTo(String to) {
        this.to = normalize(to);
    }

    private String normalize(String s) {
        if (s == null) return null;
        return s.trim().toUpperCase(Locale.ROOT);
    }
}
