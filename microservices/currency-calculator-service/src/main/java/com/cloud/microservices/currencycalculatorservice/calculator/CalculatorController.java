package com.cloud.microservices.currencycalculatorservice.calculator;

import com.cloud.microservices.currencycalculatorservice.CloudConfiguration;
import com.cloud.microservices.currencycalculatorservice.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

@RestController
public class CalculatorController {
	@Autowired
	CloudConfiguration configuration;

	@GetMapping("/currency-calculator/config")
	public CloudConfiguration getConfiguration(){
		return configuration;
	}

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-calculator/from/{from}/to/{to}/{amount}")
	public ResponseEntity<CurrencyConversion> convertCurrency(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("amount") BigDecimal amount
	){
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CurrencyConversion> conversionResponse = restTemplate.getForEntity(
				"http://localhost:8001/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class,
				urlVariables
		);

		CurrencyConversion conversion = conversionResponse.getBody();
		conversion.setAmount(amount);
		conversion.setTotalCalculatedAmount(conversion.getConversionMultiplier().multiply(amount));
		return ResponseEntity.ok(conversion);
	}
	@GetMapping("/currency-calculator-feign/from/{from}/to/{to}/{amount}")
	public ResponseEntity<CurrencyConversion> convertCurrencyeFeign(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("amount") BigDecimal amount
	) throws Exception {
		Optional<CurrencyConversion> conversionResponse = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);
		if (!conversionResponse.isPresent()) {
			throw new Exception("Failed to retrieved exchange");
		}

		CurrencyConversion conversion = conversionResponse.get();
		conversion.setAmount(amount);
		conversion.setTotalCalculatedAmount(conversion.getConversionMultiplier().multiply(amount));
		return ResponseEntity.ok(conversion);
	}
}

