package com.cloud.microservices.currencycalculatorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-calculator-service")
public class CloudConfiguration {
	private String name;

	@Autowired
	private Environment environment;


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

	public Long getPort() {
		String applicationPort = environment.getProperty("local.server.port");
		return Long.parseLong(applicationPort);
	}

	@Override
	public String toString() {
		return "CloudConfiguration{" +
				"name='" + name + '\'' +
				'}';
	}
}
