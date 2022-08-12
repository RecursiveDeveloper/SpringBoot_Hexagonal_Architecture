package com.pragma.image.application.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.image.application.repository.ImageRepository;
import com.pragma.image.domain.Image;
import com.pragma.image.infrastructure.rest.exceptions.ImageExistsException;
import com.pragma.image.infrastructure.rest.exceptions.ImageFileNotFound;
import com.pragma.image.infrastructure.rest.exceptions.ImageNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public String encodeImageBase64(MultipartFile imageFile) 
			throws UnsupportedEncodingException, IOException {
		String encodedImage;
		encodedImage = new String(Base64
				.encodeBase64(imageFile
						.getBytes()), "UTF-8");
		return encodedImage;
	}
	
	public Image findImageByIdNumber(String idNumber) {
		return imageRepository.findByIdNumber(idNumber);
	}
	
	public List<Image> listAllImages() {
		return imageRepository.findByAll();
	}
	
	public Image save(MultipartFile imageFile, String idNumber) 
			throws UnsupportedEncodingException, IOException {
		try {
			if(imageFile.getContentType() == null || imageFile.getContentType().contains("image/") == false) {
				throw new ImageFileNotFound();
			}
			Image image = new Image();
			//Codificar imageFile en base64
			image.setImage(encodeImageBase64(imageFile));
			image.setIdNumber(idNumber);
			return imageRepository.save(image);
		} catch (ImageFileNotFound e) {
			throw new ImageFileNotFound("No image file was provided.");
		} catch (Exception e) {
			throw new ImageExistsException("Image with ID number "+idNumber+" already exists.");
		} 
	}
	
	public Image updateImage(MultipartFile imageFile, String idNumber) 
			throws UnsupportedEncodingException, IOException {
		try {
			if(imageFile.getContentType() == null || imageFile.getContentType().contains("image/") == false) {
				throw new ImageFileNotFound();
			}
			Image image = findImageByIdNumber(idNumber);
			//Codificar imageFile en base64
			image.setImage(encodeImageBase64(imageFile));
			return imageRepository.save(image);
		} catch (ImageFileNotFound e) {
			throw new ImageFileNotFound("No image file was provided.");
		} catch (Exception e) {
			throw new ImageNotFoundException("Image with ID number "+idNumber+" doesn't exist.");
		}
	}
	
	public Image deleteImage(String idNumber) {
		try {
			return imageRepository.delete(findImageByIdNumber(idNumber));
		} catch (Exception e) {
			throw new ImageNotFoundException("Image with ID number "+idNumber+" doesn't exist.");
		}
	}
}