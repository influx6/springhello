package com.spring.xmlconn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(XMLApplication.class);

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			XMLPersonDOA xmlDoa = context.getBean(XMLPersonDOA.class);
			LOGGER.info("PersonDOA: {}", xmlDoa);
			LOGGER.info("PersonDOA1-Connection: {}", xmlDoa.getJDBCConnection());
			LOGGER.info("PersonDOA1-Connection2: {}", xmlDoa.getJDBCConnection());

			LOGGER.info("Beans: {}", (Object)(context.getBeanDefinitionNames()));
		};

	}

}
