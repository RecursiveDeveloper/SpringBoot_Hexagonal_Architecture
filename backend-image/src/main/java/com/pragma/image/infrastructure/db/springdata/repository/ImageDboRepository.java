package com.pragma.image.infrastructure.db.springdata.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pragma.image.application.repository.ImageRepository;
import com.pragma.image.domain.Image;
import com.pragma.image.infrastructure.db.springdata.mapper.ImageEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageDboRepository implements ImageRepository {
	
	private final SpringDataImageRepository imageRepository;
	private final ImageEntityMapper imageEntityMapper;
	
	@Override
	public Image findByIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return imageEntityMapper.toDomain(imageRepository.findByIdNumber(idNumber));
	}

	@Override
	public Image save(Image image) {
		// TODO Auto-generated method stub
		return imageEntityMapper.toDomain(imageRepository.save(imageEntityMapper.toDbo(image)));
	}

	@Override
	public Image delete(Image image) {
		// TODO Auto-generated method stub
		imageRepository.delete(imageEntityMapper.toDbo(image));
		return image;
	}

	@Override
	public List<Image> findByAll() {
		// TODO Auto-generated method stub
		return imageEntityMapper.toDomainList(imageRepository.findAll());
	}
	
}
