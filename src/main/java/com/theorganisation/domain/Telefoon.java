package com.theorganisation.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
@Table(name = "telefoon")
public class Telefoon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String telefoonNummer;

	@OneToOne(mappedBy = "telefoon", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private Employee employee;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefoonNummer() {
		return telefoonNummer;
	}

	public void setTelefoonNummer(String telefoonNummer) {
		this.telefoonNummer = telefoonNummer;
	}

	public Employee getEmployee(){
		return employee;
	}
	
}
