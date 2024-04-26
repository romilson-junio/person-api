package com.test.test.person.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.test.person.model.enums.EnumSex;

import jakarta.validation.constraints.NotBlank;

public class PersonDTO {
    
    private Long id;
    
    @NotBlank(message = "O nome é um campo obrigatório!")
    private String name;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthDate;
    
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;
    
    private EnumSex sex;
    
    private Double height;
    
    private Double weight;
    
    public PersonDTO() { }
    
	public PersonDTO(Long id, String name, LocalDate birthDate, @CPF String cpf, EnumSex sex, Double height,
			Double weight) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public EnumSex getSex() {
		return sex;
	}
	
	public void setSex(EnumSex sex) {
		this.sex = sex;
	}
	
	public Double getHeight() {
		return height;
	}
	
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
