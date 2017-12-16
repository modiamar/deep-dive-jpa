package com.modi.amar.jpa.notes.jpadeepdive.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.modi.amar.jpa.notes.jpadeepdive.domain.Person;

@Repository
public class PersonJdbcDAO {
	
	private JdbcTemplate jdbcTemplate;
	//This is an inner class and can only be used within this file
	class PersonRowMapperAlt implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	public PersonJdbcDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	//JdbcTemplate
	// select * from person
	public List<Person> findAll(){
		// Map to the object
		// when column names match to fields in POJO you can use an automatic mapper BeanPropertyRowMapper
		List<Person> personList = jdbcTemplate.query("Select * from Person",
				new PersonRowMapperAlt());
		
		return personList;
	}
	
	public Person findById(Integer id) {
		// queryForObject = query for specific object
		Person person = (Person)jdbcTemplate.queryForObject("Select * from Person where id = ?",
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
		return person;
	}
	
	public Person findByIdAndName(Integer id, String name) {
		// queryForObject = query for specific object
		Person person = (Person)jdbcTemplate.queryForObject("Select * from Person where id = ? and name = ?",
				new Object[] {id, name},
				new BeanPropertyRowMapper<Person>(Person.class));
		return person;
	}
	
	public boolean deleteById(Integer id) {
		// queryForObject = query for specific object
		String statement = "Delete from Person where id = ?";
		Object[] params = {id};
		int rows = jdbcTemplate.update(statement, params);
		boolean isDeleted = rows>0 ? true : false; 
		return isDeleted;
	}
	
	public boolean insert(Person person) {
		String statement = "insert into person (id, name, location, birth_date) values (?,?,?,?)";
		Object[] params = {person.getId(), person.getName(),
						   person.getLocation(),
						   new Timestamp(person.getBirthDate().getTime())};
		
		int rows = jdbcTemplate.update(statement, params);
		boolean isAdded = rows>0 ? true : false;
		return isAdded;	
	}
	
	public boolean update(Person person) {
		String statement = "update Person set name = ?, location = ?, birth_date = ? "
							+ "where id = ?";
		Object[] params = {person.getName(),
						   person.getLocation(),
						   new Timestamp(person.getBirthDate().getTime()),
						   person.getId()};
		
		int rows = jdbcTemplate.update(statement, params);
		boolean isUpdated = rows>0 ? true : false;
		return isUpdated;	
	}
}
