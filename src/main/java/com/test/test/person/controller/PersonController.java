package com.test.test.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.person.dto.PersonFilterDTO;
import com.test.test.person.dto.PersonDTO;
import com.test.test.person.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/search")
    public ResponseEntity<List<PersonDTO>> search(
    		@RequestParam(value = "id", required = false) Long id,
    		@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "cpf", required = false) String cpf,
    		@RequestParam(value = "masculine", required = false) String masculine,
    		@RequestParam(value = "feminine", required = false) String feminine) {
		PersonFilterDTO filter = new PersonFilterDTO(id, name, cpf, masculine, feminine);
        return ResponseEntity.ok(personService.search(filter));
    }
	
	@GetMapping
    public ResponseEntity<List<PersonDTO>> listAll() {
        return ResponseEntity.ok(personService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }
    
    @GetMapping("/imc/{id}")
    public ResponseEntity<Double> imc(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.imc(id));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> save(@Valid @RequestBody PersonDTO dto) {
        return new ResponseEntity<>(personService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable("id") Long id, @Valid @RequestBody PersonDTO dto) {
        return ResponseEntity.ok(personService.update(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody PersonDTO dto) {
    	personService.delete(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id) {
    	personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
