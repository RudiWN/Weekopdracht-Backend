package com.theorganisation.domain;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double salary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id", referencedColumnName = "id")
	private Telefoon telefoon;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setTelefoon(Telefoon tf){
		this.telefoon = tf;
	}
	public Telefoon getTelefoon(){
		return telefoon;
	}

	
}
