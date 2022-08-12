package com.pragma.backenddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pragma.image.application.repository.ImageRepository;
import com.pragma.image.application.service.ImageService;
import com.pragma.image.domain.Image;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImageServiceTest {
	
	@InjectMocks
	private ImageService imageService;
	
	@Mock
	private ImageRepository imageRepository;
	
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
	public void findImageByIdNumber() {
		imageService.findImageByIdNumber(IDNUMBER);
		verify(imageRepository).findByIdNumber(IDNUMBER);
	}
	
	@Test
	public void listAllImages() {
		imageService.listAllImages();
		verify(imageRepository).findByAll();
	}
	
	@Test
	public void save() throws UnsupportedEncodingException, IOException {
		assertEquals(imageService.save(imageFile, IDNUMBER), 
				imageRepository.save(image));
	}
	
	@Test
	public void updateImage() throws UnsupportedEncodingException, IOException {
		when(imageRepository.findByIdNumber(IDNUMBER))
			.thenReturn(image);
		imageService.updateImage(imageFile, IDNUMBER);
		verify(imageRepository).save(image);
	}
	
	@Test
	public void deleteImage() {
		when(imageRepository.findByIdNumber(IDNUMBER))
			.thenReturn(image);
		imageService.deleteImage(IDNUMBER);
		verify(imageRepository).delete(image);
	}
	
}
