package com.pragma.person.infrastructure.db.springdata.dbo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pragma.person.domain.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "people")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@NotNull
	@Column(name = "idType")
	@Convert(converter = com.pragma.person.infrastructure.db.springdata.dbo.IdTypeConverter.class)
	private DocumentType idType;
	
	@NotNull
	@Column(name = "idNumber", unique = true)
	private String idNumber;
	
	@NotNull
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "placeBirth")
	private String placeBirth;
}
