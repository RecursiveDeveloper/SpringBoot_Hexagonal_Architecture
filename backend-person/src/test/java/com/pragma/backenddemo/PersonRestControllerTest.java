package com.pragma.backenddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pragma.person.application.service.PersonService;
import com.pragma.person.domain.DocumentType;
import com.pragma.person.domain.Person;
import com.pragma.person.infrastructure.rest.spring.dto.PersonDto;
import com.pragma.person.infrastructure.rest.spring.mapper.PersonMapper;
import com.pragma.person.infrastructure.rest.spring.resources.PersonRestController;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonRestControllerTest {
	
	@InjectMocks
	PersonRestController personRestController;
	
	@Mock
	PersonService personService;

	@Mock
	PersonMapper personMapper;

	private static final Long ID = (long) 7;
	private static final String NAME = "Miguel";
	private static final String SURNAME = "Alonso";
	private static final DocumentType IDTYPE = DocumentType.PASAPORTE;
	private static final String IDNUMBER = "91576894";
	private static final Integer AGE = 23;
	private static final String PLACEBIRTH = "Bucaramanga";
	private Person person;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		
		person = mock(Person.class);
		
		when(person.getId())
			.thenReturn(ID);
		when(person.getName())
			.thenReturn(NAME);
		when(person.getSurname())
			.thenReturn(SURNAME);
		when(person.getIdType())
			.thenReturn(IDTYPE);
		when(person.getIdNumber())
			.thenReturn(IDNUMBER);
		when(person.getAge())
			.thenReturn(AGE);
		when(person.getPlaceBirth())
			.thenReturn(PLACEBIRTH);
	}
	
	@Test
	public void savePerson() throws Exception {
		MockMultipartFile image = new MockMultipartFile(
				"testImage", 
				"testImage.jpg", 
				MediaType.IMAGE_JPEG_VALUE,
				"TestImage".getBytes());
		ResponseEntity<PersonDto> response = personRestController
				.savePerson(image, personMapper.toDto(person));
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
	}
		
	@Test
	public void getPerson() {
		when(personService.getPerson(IDNUMBER))
			.thenReturn(person);
		ResponseEntity<PersonDto> response = personRestController.getPerson(IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.FOUND);
	}
	
	@Test
	public void getPeopleByAge() { 
		when(personService.getPeopleByAge(AGE))
			.thenReturn(new ArrayList<Person>());
		ResponseEntity<PersonDto> response = personRestController.getPerson(IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.FOUND);
	}
	
	@Test
	public void updatePerson() {
		when(personService.updatePerson(person))
			.thenReturn(person);
		ResponseEntity<PersonDto> response = personRestController
				.updatePerson(personMapper.toDto(person));
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void deletePerson() {
		when(personService.deletePerson(IDNUMBER))
			.thenReturn(person);
		ResponseEntity<PersonDto> response = personRestController.deletePerson(IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
}
