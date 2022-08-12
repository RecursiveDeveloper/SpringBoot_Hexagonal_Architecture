package com.pragma.image.infrastructure.db.springdata.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.image.domain.Image;
import com.pragma.image.infrastructure.db.springdata.dbo.ImageEntity;

@Mapper(componentModel = "spring")
public interface ImageEntityMapper {
	Image toDomain(ImageEntity personEntity);
	
	List<Image> toDomainList(List<ImageEntity> personEntityList);

	ImageEntity toDbo(Image image);
}
