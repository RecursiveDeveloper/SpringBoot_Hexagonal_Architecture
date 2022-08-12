package com.pragma.person.infrastructure.db.springdata.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.person.domain.Person;
import com.pragma.person.infrastructure.db.springdata.dbo.PersonEntity;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {
	Person toDomain(PersonEntity personEntity);
	
	List<Person> toDomainList(List<PersonEntity> personEntityList);

	PersonEntity toDbo(Person person);
}
