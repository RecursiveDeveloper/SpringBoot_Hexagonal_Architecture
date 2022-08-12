package com.pragma.image.infrastructure.rest.spring.resources;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.image.application.service.ImageService;
import com.pragma.image.infrastructure.rest.spring.dto.ImageDto;
import com.pragma.image.infrastructure.rest.spring.mapper.ImageMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080", methods = {
		RequestMethod.GET, RequestMethod.POST, 
		RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ImageRestController {
	
	private final ImageService imageService;
	private final ImageMapper imageMapper;

	@PostMapping(path = "image/addImage", consumes = {"multipart/form-data"})
	public ResponseEntity<ImageDto> saveImage(@Validated @RequestBody MultipartFile imageFile, String idNumber) 
			throws UnsupportedEncodingException, IOException {
		return new ResponseEntity<ImageDto>(imageMapper
				.toDto(imageService
						.save(imageFile, idNumber)), HttpStatus.CREATED);
	}
	
	@GetMapping("image/listImage")
	public ResponseEntity<ImageDto> getImage(@Validated @RequestParam String idNumber) {
		return new ResponseEntity<ImageDto>(imageMapper
				.toDto(imageService
						.findImageByIdNumber(idNumber)), HttpStatus.FOUND);
	}
	
	@GetMapping("image/listAllImages")
	public ResponseEntity<List<ImageDto>> getImages() {
		return new ResponseEntity<List<ImageDto>>(imageMapper
				.toDtoList(imageService
						.listAllImages()), HttpStatus.FOUND);
	}
	
	@PutMapping("image/updateImage")
	public ResponseEntity<ImageDto> updateImage(@Validated @RequestBody MultipartFile imageFile, String idNumber) 
			throws UnsupportedEncodingException, IOException {
		return new ResponseEntity<ImageDto>(imageMapper
				.toDto(imageService
						.updateImage(imageFile, idNumber)), HttpStatus.OK);
	}
	
	@DeleteMapping("image/deleteImage")
	public ResponseEntity<ImageDto> deleteImage(@Validated @RequestParam String idNumber) {
		return new ResponseEntity<ImageDto>(imageMapper
				.toDto(imageService
						.deleteImage(idNumber)), HttpStatus.OK);
	}
}
