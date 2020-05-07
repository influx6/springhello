package com.spring.cdibiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.cdibiz")
public class CDIApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(com.spring.hello.scan.ComponentScanApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.spring.cdibiz.CDIApplication.class)){
			CDIBusiness cdiBusiness = context.getBean(CDIBusiness.class);

			LOGGER.info("CDI: {}", cdiBusiness);
			LOGGER.info("CDOA: {}", cdiBusiness.getCdiDao());
		};

	}

}
