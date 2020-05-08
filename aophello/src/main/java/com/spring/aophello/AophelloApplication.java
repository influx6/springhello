package com.spring.aophello;

import com.spring.aophello.business.Business1;
import com.spring.aophello.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AophelloApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AophelloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("B1: {}", business1.calculateDOA());
		logger.info("B2: {}", business2.calculateDOA());

		business1.handleThrowOfSomething();
		business2.handleThrowOfSomething();
	}
}
