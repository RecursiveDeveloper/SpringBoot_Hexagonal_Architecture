package com.pragma.person.application.service;

import java.util.List;

import com.pragma.person.application.repository.PersonRepository;
import com.pragma.person.domain.Person;
import com.pragma.person.infrastructure.rest.exception.PersonExistsException;
import com.pragma.person.infrastructure.rest.exception.PersonNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonService {
	
	private final PersonRepository personRepository;

	public Person savePerson(Person person) {
		try {
			return personRepository.save(person);
		} catch (Exception e) {
			throw new PersonExistsException("Person with ID number "+person.getIdNumber()+" already exists.");
		}
	}
	
	public Person getPerson(String idNumber) {
		return personRepository.findByIdNumber(idNumber);
	}
	
	public List<Person> getPeopleByAge(Integer age) {
		return personRepository.findByAgeGreaterThanEqual(age);
	}
	
	public Person updatePerson(Person person) {
		try {
			Person modifyPerson = getPerson(person.getIdNumber());
			modifyPerson.setName(person.getName().isEmpty()
					? modifyPerson.getName() : person.getName());
			
			modifyPerson.setSurname(person.getSurname().isEmpty() 
					? modifyPerson.getSurname() : person.getSurname());
			
			modifyPerson.setIdType(person.getIdType().name().isEmpty()
					? modifyPerson.getIdType() : person.getIdType());
	
			modifyPerson.setAge(person.getAge().toString().isEmpty() 
					? modifyPerson.getAge() : person.getAge());
			
			modifyPerson.setPlaceBirth(person.getPlaceBirth().isEmpty() 
					? modifyPerson.getPlaceBirth() : person.getPlaceBirth());

			return personRepository.save(modifyPerson);
		} catch (Exception e) {
			throw new PersonNotFoundException("Person with ID number "+person.getIdNumber()+" doesn't exist.");
		}
	}
	
	public Person deletePerson(String idNumber) {
		try {
			Person deletedPerson = getPerson(idNumber);
			return personRepository.delete(deletedPerson);
		} catch (Exception e) {
			throw new PersonNotFoundException("Person with ID number "+idNumber+" doesn't exist.");
		}
		
	}
}
