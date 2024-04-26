package com.test.test.person.mapper;

import com.test.test.person.dto.PersonDTO;
import com.test.test.person.model.Person;

public class PersonMapper {
	
	public static Person entity(PersonDTO dto) {
		Person entity = new Person();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setSex(dto.getSex());
		entity.setHeight(dto.getHeight());
		entity.setWeight(dto.getWeight());
		return entity;
	}
	
	public static PersonDTO dto(Person entity) {
		PersonDTO dto = new PersonDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCpf(entity.getCpf());
		dto.setBirthDate(entity.getBirthDate());
		dto.setSex(entity.getSex());
		dto.setHeight(entity.getHeight());
		dto.setWeight(entity.getWeight());
		return dto;
	}
	
	public static void merge(PersonDTO destination, PersonDTO dto) {
		destination.setName(dto.getName());
		destination.setBirthDate(dto.getBirthDate());
		destination.setCpf(dto.getCpf());
		destination.setSex(dto.getSex());
		destination.setWeight(dto.getWeight());
		destination.setHeight(dto.getHeight());
	}

}
