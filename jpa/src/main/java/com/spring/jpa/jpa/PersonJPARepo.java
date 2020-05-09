package com.spring.jpa.jpa;

import java.util.*;
import com.spring.jpa.models.*;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJPARepo {

	@PersistenceContext
	EntityManager manager;

	public Person findById(int id) {
		return manager.find(Person.class, id);
	}

	public Person update(Person person) {
		return manager.merge(person);
	}

	public Person insert(Person person) {
		return manager.merge(person);
	}

	public void delete(int id) {
		Person existingPersonInDb = this.findById(id);
		manager.remove(existingPersonInDb);
	}

	public List<Person> findAll() {
		 TypedQuery<Person> findAllQuery = manager.createNamedQuery("find_all_persons", Person.class);
		 return findAllQuery.getResultList();
	}
}
