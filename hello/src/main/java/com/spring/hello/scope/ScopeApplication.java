package com.spring.hello.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.hello.scope")
public class ScopeApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(ScopeApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeApplication.class)){
			PersonDOA personDOA1 = context.getBean(PersonDOA.class);
			PersonDOA personDOA2 = context.getBean(PersonDOA.class);

			LOGGER.info("PersonDOA: {}", personDOA1);
			LOGGER.info("PersonDOA1-Connection: {}", personDOA1.getJDBCConnection());
			LOGGER.info("PersonDOA1-Connection2: {}", personDOA1.getJDBCConnection());

			LOGGER.info("PersonDOA: {}", personDOA2);
			LOGGER.info("PersonDOA2-Connection: {}", personDOA2.getJDBCConnection());
		};

	}

}
