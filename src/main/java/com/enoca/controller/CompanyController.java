package com.enoca.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.models.Company;
import com.enoca.models.dto.CompanyDTO;
import com.enoca.services.CompanyService; 

@RestController
@RequestMapping("/company")
public class CompanyController {

	CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@PostMapping("/save")
	ResponseEntity<String> saveProduct(@RequestBody CompanyDTO companyDTO) {

		companyService.save(companyDTO);
		return ResponseEntity.ok("company saved");
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Object> getCompanyById(@PathVariable long id) {

		return ResponseEntity.ok(companyService.findByCompanyId(id));
	}
	
	@GetMapping("/all")
	ResponseEntity<List<Company>> getAllCompany() {

		return ResponseEntity.ok(companyService.findAllCompany());
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> deleteCompany(@PathVariable long id) {
		companyService.delete(id);
		return ResponseEntity.ok("Product removed");
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<String>  update(@RequestBody CompanyDTO companyDTO, @PathVariable long id) {
		companyService.update(companyDTO,id);
		return ResponseEntity.ok("Product updated ");
	}
	
}
