package com.test.test.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.test.person.dto.PersonDTO;
import com.test.test.person.dto.PersonFilterDTO;
import com.test.test.person.handler.exception.WebApplicationException;
import com.test.test.person.mapper.PersonMapper;
import com.test.test.person.model.Person;
import com.test.test.person.repository.TaskRespository;
import com.test.test.person.repository.specification.PersonSpecification;
import com.test.test.person.service.PersonService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private TaskRespository task;
	
	@Override
	public PersonDTO save(PersonDTO dto) {
		if(task.existsByCpf(dto.getCpf())) {
			throw new WebApplicationException(HttpStatus.BAD_REQUEST, "O CPF informado já está cadastrado!");
		}
		return PersonMapper.dto(
				task.save(PersonMapper.entity(dto)));
	}

	@Override
	public PersonDTO update(Long id, PersonDTO source) {
		if(task.existsByCpfAndIdNot(source.getCpf(), id)) {
			throw new WebApplicationException(HttpStatus.BAD_REQUEST, "O CPF informado já está cadastrado!");
		}
		PersonDTO destination = findById(id);
		PersonMapper.merge(destination, source);
		return PersonMapper.dto(
				task.save(PersonMapper.entity(destination)));
	}

	@Override
	public void deleteById(Long id) {
        if(!task.existsById(id)) {
            throw new EntityNotFoundException(String.format("Nenhum registro encontrado para o id: %s!", id));
        }
		task.deleteById(id);
	}

	@Override
	public void delete(PersonDTO dto) {
		if(!task.existsById(dto.getId())) {
            throw new EntityNotFoundException(String.format("Nenhum registro encontrado para o id: %s!", dto.getId()));
        }
		task.delete(PersonMapper.entity(dto));
	}
	
	@Override
	public List<PersonDTO> search(PersonFilterDTO filter) {
		return task.findAll(PersonSpecification.build(filter)).stream().map(PersonMapper::dto).toList();
	}

	@Override
	public List<PersonDTO> listAll() {
		return task.findAll().stream().map(PersonMapper::dto).toList();
	}

	@Override
	public PersonDTO findById(Long id) {
		return PersonMapper.dto(
					task.findById(id)
			        	.orElseThrow(() ->
			            	new EntityNotFoundException(String.format("Nenhum registro encontrado para o id: %s!", id))));

	}

	@Override
	public Double imc(Long id) {
		Person person = task.findById(id)
							.orElseThrow(() ->
								new EntityNotFoundException(
										String.format("Nenhum registro encontrado para o id: %s!", id)));
		return person.calculateIMC();
	}

}
