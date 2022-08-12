package com.pragma.person.infrastructure.db.springdata.repository;

import org.springframework.stereotype.Repository;

import com.pragma.person.infrastructure.db.springdata.dbo.PersonEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SpringDataPersonRepository extends JpaRepository<PersonEntity, Long> {
	PersonEntity findByIdNumber(String idNumber);
	
	List<PersonEntity> findByAgeGreaterThanEqual(Integer age);
}
