package com.enoca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.models.Company;
import com.enoca.models.dto.CompanyDTO;
import com.enoca.repository.CompanyRepository;

@Service 
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	

	public void save(CompanyDTO companyDTO) { 
       Company company  = new Company(); 
		
        company.setName(companyDTO.getName());   
	    companyRepository.save(company);
	}

	public Object findByCompanyId(long id) {
		Optional<Company> optional =  companyRepository.findById(id);
		if(!optional.isEmpty()) {
			return optional.get();
		}else {
			return null;
		}
	}

	public List<Company> findAllCompany() {
		 List<Company> companies = companyRepository.findAll();  
		 return companies;
	}

	public void delete(long id) {
		companyRepository.deleteById(id);
		
	}

	public Optional<Object> update(CompanyDTO companyDTO, long id) {
		
		  return companyRepository.findById(id).map( company -> {
	            company.setName(companyDTO.getName());  
	            return companyRepository.save(company);
	        });
				  
				  
				  
		
	}
	
	

}
