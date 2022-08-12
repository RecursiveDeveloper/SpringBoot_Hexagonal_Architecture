package com.pragma.person.infrastructure.db.springdata.dbo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.pragma.person.domain.DocumentType;

@Converter
public class IdTypeConverter implements AttributeConverter<DocumentType, String>{

	@Override
	public String convertToDatabaseColumn(DocumentType attribute) {
		// TODO Auto-generated method stub
		if(attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public DocumentType convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		if(dbData == null) {
			return null;
		}
		try {
			return DocumentType.valueOf(dbData);
		}catch (IllegalArgumentException e) {
			return null;
		}
	}

}
