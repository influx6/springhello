package com.cloud.microservices.currencyexchangeservice.exchanges;

import com.cloud.microservices.currencyexchangeservice.CloudConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ExchangeController {

	@Autowired
	CloudConfiguration configuration;

	@Autowired
	ExchangeRepository repository;

	public ExchangeController() {
	}

	@GetMapping("/currency-exchange/config")
	public CloudConfiguration getConfiguration(){
		return configuration;
	}

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<ExchangeResult> getExchange(@PathVariable("from") String from, @PathVariable("to") String to) throws Exception {
		Optional<ExchangeResult> exchangeResult = repository.findByFromAndTo(from, to);
		if (!exchangeResult.isPresent()) {
			// we need to request currency calculation here.
			throw new Exception(String.format("No exchange available for %s and %s", from, to));
		}

		ExchangeResult result = exchangeResult.get();
		result.setPort(configuration.getPort());
		return ResponseEntity.ok(result);
	}
}
