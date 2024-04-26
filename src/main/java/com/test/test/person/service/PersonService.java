package com.test.test.person.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.test.person.dto.PersonDTO;
import com.test.test.person.dto.PersonFilterDTO;

@Service
public interface PersonService {
	PersonDTO save(PersonDTO dto);
	PersonDTO update(Long id, PersonDTO dto);
	void deleteById(Long id);
	void delete(PersonDTO dto);
	List<PersonDTO> search(PersonFilterDTO filter);
	List<PersonDTO> listAll();
	PersonDTO findById(Long id);
	Double imc(Long id);
}
