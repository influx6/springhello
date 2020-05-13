package com.cloud.microservices.currencycalculatorservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-calculator-service")
public class CloudConfiguration {
	private String name;

	public CloudConfiguration(){}

	public CloudConfiguration(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CloudConfiguration{" +
				"name='" + name + '\'' +
				'}';
	}
}
