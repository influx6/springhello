package com.cloud.microservices.limitsservice.limitconfigurations;

import com.cloud.microservices.limitsservice.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	@Autowired
	Configurations configurations;

	@GetMapping("/limits")
	public LocalLimitsConfiguration retrieveLimitConfiguration() {
		return new LocalLimitsConfiguration(configurations.getMinimum(), configurations.getMaximum());
	}
}
