package com.patryk.exchange_api.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.mail")
@Getter
@Setter
public class MailProperties {

    private String to;
    private String from;
}
