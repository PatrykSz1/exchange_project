package com.patryk.exchange_api.exchange;

public class MailSendFailedException extends RuntimeException {
    public MailSendFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
