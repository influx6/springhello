package com.cloud.microservices.currencycalculatorservice.calculator;

import com.cloud.microservices.currencycalculatorservice.CloudConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@Autowired
	CloudConfiguration configuration;

	@GetMapping("/config")
	public CloudConfiguration getConfiguration(){
		return configuration;
	}
}

