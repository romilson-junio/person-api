package com.test.test.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.test.test.person.model.Person;

@Repository
public interface TaskRespository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
	boolean existsByCpf(String cpf);
	boolean existsByCpfAndIdNot(String cpf, Long id);
}
