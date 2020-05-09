package com.spring.jpa;

import com.spring.jpa.models.Person;
import com.spring.jpa.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person newPerson  = repository.save(new Person(10006, "Alex", "Lagos", new Date()));
		logger.info("Added {}", newPerson);

		Optional<Person> person = repository.findById(10001);
		logger.info("Person: {}", person);

		Person changedPerson = repository.save(newPerson);
		logger.info("Updated {}", changedPerson);

		List<Person> personList = repository.findAll();
		logger.info("Persons {}", personList);
	}
}
