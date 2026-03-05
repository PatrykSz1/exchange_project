package com.patryk.exchange_api.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external.exchange-api")
@Getter
@Setter
public class ExchangeApiProperties {

    private String accessKey;
    private String baseUrl;
}
