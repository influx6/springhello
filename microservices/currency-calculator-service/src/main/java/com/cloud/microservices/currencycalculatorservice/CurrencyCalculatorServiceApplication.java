package com.cloud.microservices.currencycalculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cloud.microservices.currencycalculatorservice")
@EnableDiscoveryClient
public class CurrencyCalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculatorServiceApplication.class, args);
	}


}
