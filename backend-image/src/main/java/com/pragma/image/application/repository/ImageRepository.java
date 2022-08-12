package com.pragma.image.application.repository;

import java.util.List;

import com.pragma.image.domain.Image;

public interface ImageRepository {
	Image findByIdNumber(String idNumber);
	
	List<Image> findByAll();
	
	Image save(Image image);
	
	Image delete(Image image);
}