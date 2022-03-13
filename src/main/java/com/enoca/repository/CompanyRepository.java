package com.enoca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.models.Company;

public interface CompanyRepository  extends JpaRepository<Company, Long>{
	

}
