package com.patryk.exchange_api.client;

import com.patryk.exchange_api.model.ConvertResult;
import com.patryk.exchange_api.model.Currencies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "apilayerApiClient")
public interface ApilayerApiClient {

    @GetMapping("/symbols")
    Currencies symbols();

    @GetMapping("/convert")
    ConvertResult convert(@RequestParam String from,
                          @RequestParam String to,
                          @RequestParam BigDecimal amount);
}

