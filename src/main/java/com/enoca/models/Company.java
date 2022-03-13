package com.enoca.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private long id;
	
	@Column(name = "com_name")
	private String name;
	
	@OneToMany( 
			   mappedBy = "company", 
			   cascade = {CascadeType.ALL})
	 private List<Employee> employees;
	
}
