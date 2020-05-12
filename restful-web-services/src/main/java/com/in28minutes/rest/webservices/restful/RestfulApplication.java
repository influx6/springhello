package com.in28minutes.rest.webservices.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	// If you wish to setup the message source manually or set 'spring.messages.basename=messages'
	// application.properties.
	//	@Bean
	//	public ResourceBundleMessageSource bundleMessageSource() {
	//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	//		messageSource.setBasename("messages");
	//		return messageSource;
	//	}
}
