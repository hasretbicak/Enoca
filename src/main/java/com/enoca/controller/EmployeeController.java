package com.enoca.controller;
 

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.models.Employee;
import com.enoca.models.dto.EmployeeDTO; 
import com.enoca.services.EmployeeService;

@RestController

@RequestMapping("/employee")
public class EmployeeController {
 
	private EmployeeService employeeService;	

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService; 
	}
		
	   @PostMapping("/save")
	   ResponseEntity<String> saveProduct(@RequestBody Employee  employee) {

			employeeService.save(employee);
			return ResponseEntity.ok("Employee saved");
		}
	
	   @GetMapping("/employee/{id}")
	    public Optional<Employee> getEmployeeById(@PathVariable long id) {

	        return  employeeService.findById(id);
	    }
	
	   @PutMapping("/{id}")
	    public Optional<Object> update( @PathVariable long id ,@RequestBody EmployeeDTO employeeDTO ) {

	        return employeeService.updateById(id,employeeDTO);
	    }
	   
	   
	   @DeleteMapping("/employee/{id}")
	    public void delete(@PathVariable long id ) {  
	            employeeService.delete(id); 
	   }
	
	   @PostMapping("/calculate-salary")
	   public void calculateSalary(  @RequestBody int age, @RequestBody double salary, @RequestBody int year) {
		   employeeService.calculateSalary(age,salary,year);
	   }
	
}
 	