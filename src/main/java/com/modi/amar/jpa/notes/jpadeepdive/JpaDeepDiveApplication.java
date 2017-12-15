package com.modi.amar.jpa.notes.jpadeepdive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.modi.amar.jpa.notes.jpadeepdive.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class JpaDeepDiveApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaDeepDiveApplication.class, args);
		PersonJdbcDAO personJdbcDAO = context.getBean(PersonJdbcDAO.class);

		personJdbcDAO.findAll().forEach(person -> {
			System.out.println(person);
		});
	}
}
