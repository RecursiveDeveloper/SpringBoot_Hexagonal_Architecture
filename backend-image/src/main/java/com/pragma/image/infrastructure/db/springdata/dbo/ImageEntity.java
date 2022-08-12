package com.pragma.image.infrastructure.db.springdata.dbo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "images")
@Getter
@Setter
@NoArgsConstructor
public class ImageEntity {
	@Id
	@Field(name = "_id", targetType = FieldType.OBJECT_ID)
	private String id;
	
	@NotNull
	@Indexed(name = "idNumber", unique = true)
	@Field(name = "idNumber")
	private String idNumber;
	
	@Field(name = "image")
	private String image;
}
