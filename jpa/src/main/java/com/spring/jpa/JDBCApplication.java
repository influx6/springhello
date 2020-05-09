package com.spring.jpa;

import com.spring.jpa.jdbc.PersonJdbcDOA;
import com.spring.jpa.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JDBCApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDOA personJdbcDOA;

	public static void main(String[] args) {
		SpringApplication.run(JDBCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int totalRowAdded = personJdbcDOA.insert(new Person(10006, "Alex", "Lagos", new Date()));
		logger.info("TotalAdded {}", totalRowAdded);

		List<Person> personList = personJdbcDOA.findAll();
		logger.info("Persons {}", personList);

		Person person = personJdbcDOA.findById(10001);
		logger.info("Person: {}", person);

		int totalRowUpdated = personJdbcDOA.update(new Person(10006, "Alex", "Lagos, Nigeria", new Date()));
		logger.info("TotalUpdated {}", totalRowUpdated);

		personList = personJdbcDOA.findAll();
		logger.info("Persons {}", personList);
	}
}
