package com.cloud.microservices.currencyexchangeservice.exchanges;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class ExchangeResult {
	@Id
	@GeneratedValue(generator="exchange_result_sequence", strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name="from_ccy")
	private String from;

	@NotNull
	@Column(name="to_ccy")
	private String to;

	@NotNull
	private BigDecimal conversionMultiplier;

	@Transient
	private Long port;

	public ExchangeResult() {
	}

	public ExchangeResult(Integer id, String from, String to, BigDecimal conversionMultiplier, Long port) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiplier = conversionMultiplier;
		this.port = port;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public BigDecimal getConversionMultiplier() {
		return conversionMultiplier;
	}

	public void setConversionMultiplier(BigDecimal conversionMultiplier) {
		this.conversionMultiplier = conversionMultiplier;
	}

	@Override
	public String toString() {
		return "ExchangeResult{" +
				"id=" + id +
				", from='" + from + '\'' +
				", to='" + to + '\'' +
				", conversionMultiplier=" + conversionMultiplier +
				'}';
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}
}
