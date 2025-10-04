package com.patryk.exchange_api.service;

import com.patryk.exchange_api.client.ApilayerApiClient;
import com.patryk.exchange_api.exchange.ExchangeBadRequestException;
import com.patryk.exchange_api.model.ConvertRequest;
import com.patryk.exchange_api.model.ConvertResult;
import com.patryk.exchange_api.model.Currencies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final ApilayerApiClient apilayerApiClient;
    private final MailService mailService;

    //TODO Cachowanie
    public Currencies getAllCurrencies() {
        return apilayerApiClient.symbols();
    }

    public ConvertResult convert(ConvertRequest convertRequest) {
        if (convertRequest.getAmount() == null || convertRequest.getAmount().signum() < 0) {
            throw new ExchangeBadRequestException("amount must be >= 0");
        }
        String from = normalize(convertRequest.getFrom());
        String to = normalize(convertRequest.getTo());

        ConvertResult result = apilayerApiClient.convert(from, to, convertRequest.getAmount());

        try {
            mailService.sendConversionConfirmation(result);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    private String normalize(String s) {
        if (s == null || s.isBlank())
            throw new ExchangeBadRequestException("value is blank");
        return s.trim().toUpperCase(Locale.ROOT);
    }
}
