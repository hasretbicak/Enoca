package com.enoca.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.enoca.models.Employee;
import com.enoca.models.dto.EmployeeDTO;
import com.enoca.repository.EmployeeRepository;

public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee findById(long id) {
		  return employeeRepository.findById(id);
	}

	public Optional<Object> updateById(long id, EmployeeDTO employeeDTO) {

        return employeeRepository.findById(id).map( employee -> {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary()); 
            employee.setAge(employeeDTO.getAge());
            employee.setYear(employeeDTO.getYear());
            employee.setCompany(employeeDTO.getCompany());
            return employeeRepository.save(employee);
        });
	}

	 

	public void delete(long id) {
		 employeeRepository.deleteById(id);
		
	}

	public void save(Employee employee ) {

		 employeeRepository.save(employee);
		
	}

	public ResponseEntity<String> calculateSalary(  int age , double salary,  int year) {
		
		if(age<=25 && age>=20) {
			salary =  salary + year*(salary*0.2);
		}
		else if(age<=36 && age>25) {
			salary =  salary + year*(salary*0.16);
		}
		else if(age<=30 && age>25) {
			salary =  salary + year*(salary*0.16);
		}
		else if(age<=36 && age>31) {
			salary =  salary + year*(salary*0.10);
		}
		else if(age<=65 && age>36){
			salary =  salary + year*(salary*0.06);
		}
		else {
			return ResponseEntity.ok("Hatalı giriş yapıldı");
		}
		return null;
		 
		
	}

}
