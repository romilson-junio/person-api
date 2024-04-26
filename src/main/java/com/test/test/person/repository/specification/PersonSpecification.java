package com.test.test.person.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.test.test.person.dto.PersonFilterDTO;
import com.test.test.person.model.Person;

import io.micrometer.common.util.StringUtils;

public class PersonSpecification {
	
	public static Specification<Person> build(PersonFilterDTO filter) {
		return Specification.anyOf(or(filter));
	}
	
	private static List<Specification<Person>> or(PersonFilterDTO filter) {
		List<Specification<Person>> or = new ArrayList<>();

		Optional.ofNullable(filter.getId()).ifPresent(id ->
			or.add((root, query, builder) ->
				builder.equal(root.get("id"), id))
		);
		
		Optional.ofNullable(filter.getName()).ifPresent(name ->
			or.add((root, query, builder) ->
				builder.like(builder.lower(root.get("name")), "%"+name.toLowerCase()+"%"))
		);

		Optional.ofNullable(filter.getCpf()).ifPresent(cpf ->
			or.add((root, query, builder) ->
				builder.like(builder.lower(root.get("cpf")), "%"+cpf.toLowerCase()+"%"))
		);
		
		Optional.ofNullable(filter.getSexM()).ifPresent(sex ->
			or.add((root, query, builder) ->
				builder.equal(builder.lower(root.get("sex")), sex.toLowerCase()))
		);
		
		Optional.ofNullable(filter.getSexF()).ifPresent(sex ->
			or.add((root, query, builder) ->
				builder.equal(builder.lower(root.get("sex")), sex.toLowerCase()))
		);

		return or;
	}

}
