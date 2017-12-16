package com.modi.amar.jpa.notes.jpadeepdive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.modi.amar.jpa.notes.jpadeepdive.domain.Person;
import com.modi.amar.jpa.notes.jpadeepdive.jdbc.PersonJdbcDAO;

public class PersonJdbcDAOTest {
	
	@Autowired
	private PersonJdbcDAO personJdbcDAO;

	@Before
	public void setUp() throws Exception {
		//PersonJdbcDAO personJdbcDAO = new PersonJdbcDAO(jdbcTemplate);
		
	}

	@Test
	public void testFindById() {
		Person person = personJdbcDAO.findById(10001);
		System.out.println(person.getName());
		assertEquals("Amar", person.getName());
		
	}

}
