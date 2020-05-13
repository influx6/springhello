package com.cloud.microservices.currencycalculatorservice.calculator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private Long port;
	private BigDecimal amount;
	private BigDecimal totalCalculatedAmount;
	private BigDecimal conversionMultiplier;

	public CurrencyConversion() {
	}

	public CurrencyConversion(Long id, String from, String to, Long port, BigDecimal amount, BigDecimal totalCalculatedAmount, BigDecimal conversionMultiplier) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.port = port;
		this.amount = amount;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.conversionMultiplier = conversionMultiplier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public BigDecimal getConversionMultiplier() {
		return conversionMultiplier;
	}

	public void setConversionMultiplier(BigDecimal conversionMultiplier) {
		this.conversionMultiplier = conversionMultiplier;
	}
}
