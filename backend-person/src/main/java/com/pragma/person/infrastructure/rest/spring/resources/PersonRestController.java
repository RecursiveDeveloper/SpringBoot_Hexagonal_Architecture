package com.pragma.person.infrastructure.rest.spring.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.person.application.service.PersonService;
import com.pragma.person.infrastructure.rest.spring.dto.PersonDto;
import com.pragma.person.infrastructure.rest.spring.mapper.PersonMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PersonRestController {
	
	private final PersonService personService;
	private final PersonMapper personMapper;
	//private final WebClient.Builder webClientBuilder;
	
	@PostMapping(path = "person/addPerson", consumes = {"multipart/form-data" })
	public ResponseEntity<PersonDto> savePerson(@Validated @RequestBody MultipartFile ImageFile, 
			PersonDto personDto) throws Exception {
		return new ResponseEntity<PersonDto>(personMapper
				.toDto(personService
						.savePerson(personMapper
								.toDomain(personDto))), HttpStatus.CREATED);
	}
	
	@GetMapping("person/listPerson")
	public ResponseEntity<PersonDto> getPerson(@Validated @RequestParam String idNumber) {
		return new ResponseEntity<PersonDto>(personMapper
				.toDto(personService
						.getPerson(idNumber)), HttpStatus.FOUND);
	}
	
	@GetMapping("person/listPeopleByAge")
	public ResponseEntity<List<PersonDto>> getPeopleByAge(@Validated @RequestParam Integer age) {
		return new ResponseEntity<List<PersonDto>>(personMapper
				.toDtoList(personService
						.getPeopleByAge(age)), HttpStatus.FOUND);
	}
	

	@PutMapping("person/updatePerson")
	public ResponseEntity<PersonDto> updatePerson(@Validated @RequestBody PersonDto personDto) {
		return new ResponseEntity<PersonDto>(personMapper
				.toDto(personService
						.updatePerson(personMapper.toDomain(personDto))), HttpStatus.OK);
	}
	
	@DeleteMapping("person/deletePerson")
	public ResponseEntity<PersonDto> deletePerson(@Validated @RequestParam String idNumber) {
		return new ResponseEntity<PersonDto>(personMapper
				.toDto(personService
						.deletePerson(idNumber)), HttpStatus.OK);
		
	}
}

/*
MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
bodyBuilder.part("imageFile", ImageFile.getResource());
bodyBuilder.part("idNumber", personDto.getIdNumber());

webClientBuilder.build()
	.post()
	.uri("http://localhost:8081/image/addImage")
	.contentType(MediaType.MULTIPART_FORM_DATA)
	.body(BodyInserters.fromMultipartData(bodyBuilder.build()))
	.exchangeToMono(response -> {
        if(response.statusCode().equals(HttpStatus.CREATED)) {
            return response.bodyToMono(String.class).thenReturn(response.toString().getClass());
        }else {
            throw new ServiceException("Error uploading file with status code => "+response.statusCode());
        }
      }).blockOptional().orElseThrow(null);
*/

/*
webClientBuilder.build()
.get()
.uri(uriBuilder -> uriBuilder
		.path("http://localhost:8081/image/listImage")
		.queryParam("idNumber",idNumber)
		.build())
.exchangeToMono(response -> {
    if(response.statusCode().equals(HttpStatus.OK)) {
        return response.bodyToMono(String.class).thenReturn(response.toString().getClass());
    }else {
        throw new ServiceException("Error retrieving file with status code => "+response.statusCode());
    }
  }).blockOptional().orElseThrow(null);
*/
