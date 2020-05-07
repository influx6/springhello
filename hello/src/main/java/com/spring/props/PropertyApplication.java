package com.spring.props;

import com.spring.hello.basics.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class PropertyApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(PropertyApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyApplication.class)){
			ExternalService bs = context.getBean(ExternalService.class);
			String serviceUrl = bs.getServiceUrl();

			LOGGER.info("Result: {}", serviceUrl);
		};

	}

}
