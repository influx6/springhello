package com.spring.hello.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.hello.basics")
public class HelloApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(HelloApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloApplication.class)){
			BinarySearchImpl bs = context.getBean(BinarySearchImpl.class);
			int result = bs.binarySearch(new int[]{12, 4,6}, 3);

			LOGGER.info("Result: {}", result);
		};

	}

}
