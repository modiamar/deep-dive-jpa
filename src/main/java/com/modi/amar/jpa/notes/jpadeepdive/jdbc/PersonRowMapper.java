package com.modi.amar.jpa.notes.jpadeepdive.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.modi.amar.jpa.notes.jpadeepdive.domain.Person;

public class PersonRowMapper implements RowMapper<Person>{
	
	private Person person;

	public PersonRowMapper(Person person) {
		super();
		this.person = person;
	}

	public PersonRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	  //Person person = new Person();
	  
	  person.setId(rs.getInt("id"));
	  person.setName(rs.getString("name"));
	  person.setLocation(rs.getString("location"));
	  person.setBirthDate(rs.getTimestamp("birth_date"));
	  return person;
	  }  
	
	

}
