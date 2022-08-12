package com.pragma.person.application.repository;

import java.util.List;

import com.pragma.person.domain.Person;
import com.pragma.person.infrastructure.rest.exception.PersonExistsException;
import com.pragma.person.infrastructure.rest.exception.PersonNotFoundException;

public interface PersonRepository {
	Person findByIdNumber(String idNumber);
	
	Person save(Person person);
	
	List<Person> findByAgeGreaterThanEqual(Integer age);
	
	Person delete(Person person);
}