package com.pragma.image.infrastructure.db.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pragma.image.infrastructure.db.springdata.dbo.ImageEntity;

@Repository
public interface SpringDataImageRepository extends MongoRepository<ImageEntity, String> {
	ImageEntity findByIdNumber(String idNumber);
}
