package com.cloud.microservices.currencyexchangeservice.exchanges;

import com.cloud.microservices.currencyexchangeservice.CloudConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

	@Autowired
	CloudConfiguration configuration;

	public ExchangeController() {
	}

	@GetMapping("/config")
	public CloudConfiguration getConfiguration(){
		return configuration;
	}
}
