package com.pragma.person.infrastructure.db.springdata.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pragma.person.application.repository.PersonRepository;
import com.pragma.person.domain.Person;
import com.pragma.person.infrastructure.db.springdata.mapper.PersonEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonDboRepository implements PersonRepository {
	
	private final SpringDataPersonRepository personRepository;
	private final PersonEntityMapper personEntityMapper;
	
	@Override
	public Person findByIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return personEntityMapper.toDomain(personRepository.findByIdNumber(idNumber));
	}
	
	@Override
	public List<Person> findByAgeGreaterThanEqual(Integer age) {
		// TODO Auto-generated method stub
		return personEntityMapper.toDomainList(personRepository.findByAgeGreaterThanEqual(age));
	}
	
	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personEntityMapper.toDomain(personRepository.save(personEntityMapper.toDbo(person)));
	}

	@Override
	public Person delete(Person person) {
		// TODO Auto-generated method stub
		personRepository.delete(personEntityMapper.toDbo(person));
		return person;
	}
}
