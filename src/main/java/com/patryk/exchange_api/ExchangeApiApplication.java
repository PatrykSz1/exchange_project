package com.patryk.exchange_api;

import com.patryk.exchange_api.properties.ExchangeApiProperties;
import com.patryk.exchange_api.properties.MailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties({ExchangeApiProperties.class, MailProperties.class})
@EnableFeignClients(basePackages = "com.patryk.exchange_api.client")
public class ExchangeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApiApplication.class, args);
	}

}
