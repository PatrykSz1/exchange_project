package com.patryk.exchange_api.exchange;

public class ExchangeBadRequestException extends RuntimeException {
    public ExchangeBadRequestException(String message) {
        super(message);
    }
}
