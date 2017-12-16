package com.modi.amar.jpa.notes.jpadeepdive;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.modi.amar.jpa.notes.jpadeepdive.domain.Person;
import com.modi.amar.jpa.notes.jpadeepdive.jdbc.PersonJdbcDAO;
import com.modi.amar.jpa.notes.jpadeepdive.repositories.PersonJpaRepository;

@SpringBootApplication
public class JpaDeepDiveApplication implements CommandLineRunner {
	
	@Autowired 
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
	    SpringApplication.run(JpaDeepDiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(personRepository.findById(10002).get());
		System.out.println(personJpaRepository.findById(10002));
		System.out.println(personJpaRepository.insert(
				new Person("Saw", "Arizona",new Timestamp(new Date().getTime()))));	
		System.out.println(personJpaRepository.update(
				new Person("Saw", "Canada",new Timestamp(new Date().getTime()))));
		System.out.println(personJpaRepository.deleteById(10002));
		System.out.println(personJpaRepository.findAll());
		System.out.println(personJpaRepository.findByName("Amar"));
		
		
	}
}
