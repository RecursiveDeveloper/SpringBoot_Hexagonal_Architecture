package com.pragma.person.infrastructure.rest.spring.dto;

import com.pragma.person.domain.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {	
	private Long id;
	private String name;
	private String surname;
	private DocumentType idType;
	private String idNumber;
	private Integer age;
	private String placeBirth;
}