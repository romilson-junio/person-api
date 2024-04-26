package com.test.test.person.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.test.person.model.enums.EnumSex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_persons")
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate birthDate;
    
    @Column(name = "cpf", unique = true)
    private String cpf;
    
    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private EnumSex sex;
    
    @Column(name = "altura")
    private Double height;
    
    @Column(name = "peso")
    private Double weight;
    
    public Person() { }

	public Person(Long id, String name, LocalDate birthDate, String cpf, EnumSex sex, Double height, Double weight) {
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
	
	public Double calculateIMC() {
		Double imc;
		if(sex.equals(EnumSex.M)) {
			imc = ( 72.7 * height ) - 58;
		}
		imc = ( 62.1 * height ) - 44.7;
		return Math.round(imc * 100.0) / 100.0;
	}

}
