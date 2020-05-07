package com.spring.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalService {
	// from property file: external.service.url
	@Value("${external.service.url}")
	private String serviceURL;

	public String getServiceUrl() {
		return this.serviceURL;
	}
}
