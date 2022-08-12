package com.pragma.backenddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pragma.image.application.service.ImageService;
import com.pragma.image.domain.Image;
import com.pragma.image.infrastructure.rest.spring.dto.ImageDto;
import com.pragma.image.infrastructure.rest.spring.mapper.ImageMapper;
import com.pragma.image.infrastructure.rest.spring.resources.ImageRestController;


@RunWith(SpringJUnit4ClassRunner.class)
public class ImageRestControllerTest {	
	
	@InjectMocks
	private ImageRestController imageRestController;
	
	@Mock
	private ImageService imageService;
	
	@Mock
	private ImageMapper imageMapper;
	
	private static final String ID = "1s3fd06we";
	private static final String IDNUMBER = "91576894";
	private static final String IMAGE = "data:image/png;base64,iVBORw0KGg5CYII=";
	private Image image;
	private MockMultipartFile imageFile;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		image = mock(Image.class);
		
		when(image.getId())
		.thenReturn(ID);
		when(image.getImage())
			.thenReturn(IMAGE);
		when(image.getIdNumber())
			.thenReturn(IDNUMBER);
		
		imageFile = new MockMultipartFile(
				"testImage", 
				"testImage.jpg",
				MediaType.IMAGE_JPEG_VALUE,
				"testImage".getBytes());
	}
	
	@Test
	public void saveImage() throws UnsupportedEncodingException, IOException { 
		ResponseEntity<ImageDto> response = imageRestController.saveImage(imageFile, IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test
	public void getImage() {
		when(imageService.findImageByIdNumber(IDNUMBER))
			.thenReturn(image);
		ResponseEntity<ImageDto> response = imageRestController.getImage(IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.FOUND);
	}
	
	@Test
	public void getImages() {
		when(imageService.listAllImages())
			.thenReturn(new ArrayList<Image>());
		ResponseEntity<List<ImageDto>> response = imageRestController.getImages();
		assertEquals(response.getStatusCode(), HttpStatus.FOUND);
	}
	
	@Test
	public void updateImage() throws UnsupportedEncodingException, IOException {
		when(imageService.updateImage(imageFile, IDNUMBER))
			.thenReturn(image);
		ResponseEntity<ImageDto> response = imageRestController.updateImage(imageFile, IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void deleteImage() {
		when(imageService.deleteImage(IDNUMBER))
		.thenReturn(image);
		ResponseEntity<ImageDto> response = imageRestController.deleteImage(IDNUMBER);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
}
