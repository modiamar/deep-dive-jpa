package com.modi.amar.jpa.notes.jpadeepdive.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.modi.amar.jpa.notes.jpadeepdive.domain.Person;

@Repository
public class PersonJdbcDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public PersonJdbcDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	//JdbcTemplate
	// select * from person
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		// Map to the object
		// when column names match to fields in POJO you can use an automatic mapper BeanPropertyRowMapper
		List<Person> personList = jdbcTemplate.query("Select * from Person",
				new BeanPropertyRowMapper<Person>(Person.class));
		
		return personList;
	}

}
