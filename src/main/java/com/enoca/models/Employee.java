package com.enoca.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	
	@Column(name = "salary")
	private double salary;
	
	
	@Column(name = "work_year")
	private int year;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name ="company_id")
	private Company company;
	
	
	
	
}
