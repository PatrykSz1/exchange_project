package com.patryk.exchange_api.service;

import com.patryk.exchange_api.model.ConvertResult;
import com.patryk.exchange_api.properties.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;
    //TODO asynch wysylka
    public void sendConversionConfirmation(ConvertResult result) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getFrom());
        msg.setTo(mailProperties.getTo());
        msg.setSubject("Currency exchange confirmation");

        String body = """
        Exchange completed

        From: %s
        To:   %s
        Amount: %s
        Rate:   %s
        Result: %s
        Date:   %s
        """.formatted(
                result.getQuery().getFrom(),
                result.getQuery().getTo(),
                result.getQuery().getAmount(),
                result.getInfo().getRate(),
                result.getResult(),
                result.getDate()
        );

        msg.setText(body);
        mailSender.send(msg);
    }
}
