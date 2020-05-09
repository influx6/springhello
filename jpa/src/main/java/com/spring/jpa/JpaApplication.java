package com.spring.jpa;

import com.spring.jpa.jpa.PersonJPARepo;
import com.spring.jpa.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

//@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJPARepo personJPARepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person newPerson  = personJPARepo.insert(new Person(10006, "Alex", "Lagos", new Date()));
		logger.info("Added {}", newPerson);

		Person person = personJPARepo.findById(10001);
		logger.info("Person: {}", person);

		person.setName("Alex Ewe");
		Person changedPerson = personJPARepo.update(newPerson);
		logger.info("Updated {}", changedPerson);

		List<Person> personList = personJPARepo.findAll();
		logger.info("Persons {}", personList);
	}
}
