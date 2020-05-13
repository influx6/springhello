package com.cloud.microservices.limitsservice.limitconfigurations;

import com.cloud.microservices.limitsservice.Configurations;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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

	@GetMapping("/limits-bad")
	@HystrixCommand(defaultFallback="fallbackRetrieveCommand")
	public LocalLimitsConfiguration retrieveConfig() {
		throw new RuntimeException("Something bad");
	}

	public LocalLimitsConfiguration fallbackRetrieveCommand() {
		return new LocalLimitsConfiguration(200, 2000);
	}
}
