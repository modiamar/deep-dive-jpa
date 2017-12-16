package com.modi.amar.jpa.notes.jpadeepdive.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.modi.amar.jpa.notes.jpadeepdive.domain.Person;


@Repository
@Transactional
public class PersonJpaRepository {
	//Operations are stored in the persistenceContext
	// EntityManager is interface to PersistenceContext
	
	// Manages the entities
	@PersistenceContext
    EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person insert(Person person) {
		// If person does NOT have id, then it will create NEW row
		 entityManager.merge(person);
		 return person;
	}
	
	public Person update(Person person) {
		person.setId(1);
		// If person does have id, it will update it to correlate to it
		entityManager.merge(person);
		return person;
	}
	
	
	public int deleteById(int id) {
		// If person does have id, it will update it to correlate to it
		Person person = entityManager.find(Person.class, id);
		entityManager.remove(person);
		return id;
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> findAllQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		return findAllQuery.getResultList();
	}
	
	public Person findByName(String name) {
		//String statement = "Select p from Person p where p.name = :name";
		TypedQuery<Person> personNameQuery = entityManager.createNamedQuery("find_by_id", Person.class);
		return personNameQuery.setParameter("name", name).getSingleResult();
	}
	
}
