package com.pragma.image.infrastructure.rest.spring.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.image.domain.Image;
import com.pragma.image.infrastructure.rest.spring.dto.ImageDto;

@Mapper(componentModel = "spring")
public interface ImageMapper {
	ImageDto toDto(Image image);
	
	List<ImageDto> toDtoList(List<Image> image);
	
	Image toDomain(ImageDto imageDto);
	
	List<Image> toDomainList(List<ImageDto> imageDtoList);
}
