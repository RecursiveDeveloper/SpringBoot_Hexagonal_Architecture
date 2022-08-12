package com.pragma.person.domain;

public class Person {
	private Long id;
	private String name;
	private String surname;
	private DocumentType idType;
	private String idNumber;
	private Integer age;
	private String placeBirth;

	public Person() {}

	public Person(Long id, String name, String surname, DocumentType idType, String idNumber, Integer age,
			String placeBirth) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.idType = idType;
		this.idNumber = idNumber;
		this.age = age;
		this.placeBirth = placeBirth;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public DocumentType getIdType() {
		return idType;
	}
	public void setIdType(DocumentType idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPlaceBirth() {
		return placeBirth;
	}
	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
	}
}