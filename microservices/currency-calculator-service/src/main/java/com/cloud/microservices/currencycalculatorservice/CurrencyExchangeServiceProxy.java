package com.cloud.microservices.currencycalculatorservice;

import com.cloud.microservices.currencycalculatorservice.calculator.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="zuul-api-gateway/")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public Optional<CurrencyConversion> retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
