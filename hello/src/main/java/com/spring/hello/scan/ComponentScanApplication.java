package com.spring.hello.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.spring.componentscan.ComponentDOA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.componentscan")
public class ComponentScanApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(ComponentScanApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanApplication.class)){
			ComponentDOA componentDOA1 = context.getBean(ComponentDOA.class);
			ComponentDOA componentDOA2 = context.getBean(ComponentDOA.class);

			LOGGER.info("ComponentDOA: {}", componentDOA1);
			LOGGER.info("ComponentDOA1-Connection: {}", componentDOA1.getJDBCConnection());
			LOGGER.info("ComponentDOA1-Connection2: {}", componentDOA1.getJDBCConnection());

			LOGGER.info("ComponentDOA: {}", componentDOA2);
			LOGGER.info("ComponentDOA2-Connection: {}", componentDOA2.getJDBCConnection());
		};

	}

}
