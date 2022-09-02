package com.pragma.backenddemo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pragma.person.application.repository.PersonRepository;
import com.pragma.person.application.service.PersonService;
import com.pragma.person.domain.DocumentType;
import com.pragma.person.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

	@InjectMocks
	private PersonService personService;
	
	@Mock
	private PersonRepository personRepository;
	
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
	public void savePerson() {
		//Act
		personService.savePerson(person);
		
		//Assert 
		verify(personRepository).save(person);
	}
	
	@Test
	public void getPerson() {
		personService.getPerson(IDNUMBER);
		verify(personRepository).findByIdNumber(IDNUMBER);
	}
	
	@Test
	public void getPeopleByAge() {
		personService.getPeopleByAge(AGE);
		verify(personRepository).findByAgeGreaterThanEqual(AGE);
	}
	
	@Test
	public void updatePerson() {
		when(personRepository.findByIdNumber(IDNUMBER))
			.thenReturn(person);
		personService.updatePerson(person);
		verify(personRepository).save(person);
	}
	
	@Test
	public void deletePerson() {
		when(personRepository.findByIdNumber(IDNUMBER))
			.thenReturn(person);
		personService.deletePerson(IDNUMBER);
		verify(personRepository).delete(person);
	}
}
