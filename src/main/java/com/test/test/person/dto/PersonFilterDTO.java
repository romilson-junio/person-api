package com.test.test.person.dto;

public class PersonFilterDTO {

	private Long id;
	private String name;
	private String cpf;
	private String sexM;
	private String sexF;
	
	public PersonFilterDTO() { }
	
	public PersonFilterDTO(Long id, String name, String cpf, String sexM, String sexF) {
		super();
		this.id   = id;
		this.name = name;
		this.cpf  = cpf;
		this.sexM = sexM;
		this.sexF = sexF;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexM() {
		return sexM;
	}

	public void setSexM(String sexM) {
		this.sexM = sexM;
	}

	public String getSexF() {
		return sexF;
	}

	public void setSexF(String sexF) {
		this.sexF = sexF;
	}
	
	
}
