package com.enoca.models.dto;
 
import com.enoca.models.Company;

import lombok.Data;

@Data
public class EmployeeDTO {
	
 
	private long id;
	
	private String name;
	 
	private int age;
	
	 
	private double salary;
	 
	private int year;
	 
	private Company company;

}
