package com.spring.jpa.jdbc;

import com.spring.jpa.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDOA {

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setLocation(resultSet.getString("location"));
			person.setBirthDate(resultSet.getTimestamp("birth_date"));
			return person;
		}
	}

	@Autowired
	JdbcTemplate jbdbTemplate;

	public Person findById(int id) {
		return this.jbdbTemplate.queryForObject(
				"select * from person where id=?",
				new Object[]{id},
				new PersonRowMapper()
		);
	}

	public List<Person> findAll() {
		return jbdbTemplate.query("select * from person", new PersonRowMapper());
	}

	public int insert(Person person) {
		return jbdbTemplate.update("insert  into person (id, name, location, birth_date) VALUES (?, ?, ?, ?)", new Object[]{
				person.getId(),
				person.getName(),
				person.getLocation(),
				new Timestamp(person.getBirthDate().getTime())
		});
	}

	public int update(Person person) {
		return jbdbTemplate.update("update person SET name = ?, location = ?, birth_date = ? where id = ?", new Object[]{
				person.getName(),
				person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()),
				person.getId(),
		});
	}
}
