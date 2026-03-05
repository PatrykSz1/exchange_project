package com.patryk.exchange_api.service;

import com.patryk.exchange_api.model.ConvertResponse;
import com.patryk.exchange_api.properties.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;

    @Async("mailExecutor")
    public void trySendConversionConfirmation(ConvertResponse r) {
        try {
            sendConversionConfirmation(r);
        } catch (Exception ignored) { }
    }

    public void sendConversionConfirmation(ConvertResponse r) {
        var msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getFrom());
        msg.setTo(mailProperties.getTo());
        msg.setSubject("Currency exchange confirmation");
        msg.setText("""
                Exchange completed

                From:   %s
                To:     %s
                Amount: %s
                Result: %s
                Date:   %s
                """.formatted(r.getFrom(), r.getTo(), r.getAmount(), r.getResult(), r.getDate()));
        mailSender.send(msg);
    }
}
