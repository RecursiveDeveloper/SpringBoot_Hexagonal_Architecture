package com.pragma.person.infrastructure.rest.spring.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.person.domain.Person;
import com.pragma.person.infrastructure.rest.spring.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonDto toDto(Person person);
	
	List<PersonDto> toDtoList(List<Person> person);
	
	Person toDomain(PersonDto personDto);
	
	List<Person> toDomainList(List<PersonDto> personDtoList);
}
