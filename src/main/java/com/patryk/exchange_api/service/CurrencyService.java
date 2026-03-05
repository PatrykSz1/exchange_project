package com.patryk.exchange_api.service;

import com.patryk.exchange_api.client.ApilayerApiClient;
import com.patryk.exchange_api.model.ApiLayerConvertResponse;
import com.patryk.exchange_api.model.ConvertRequest;
import com.patryk.exchange_api.model.ConvertResponse;
import com.patryk.exchange_api.model.Currencies;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final ApilayerApiClient apilayerApiClient;
    private final MailService mailService;

    @Cacheable("currencies")
    public Currencies getAllCurrencies() {
        return apilayerApiClient.symbols();
    }

    public ConvertResponse convert(ConvertRequest convertRequest) {
        ApiLayerConvertResponse api =
                apilayerApiClient.convert(
                        convertRequest.getFrom(),
                        convertRequest.getTo(),
                        convertRequest.getAmount());

        ConvertResponse out = ConvertResponse.builder()
                .from(convertRequest.getFrom())
                .to(convertRequest.getTo())
                .amount(convertRequest.getAmount())
                .result(api.getResult())
                .date(api.getDate())
                .build();

        mailService.trySendConversionConfirmation(out);
        return out;
    }
}
