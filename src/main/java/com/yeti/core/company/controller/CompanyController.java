package com.yeti.core.company.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.yeti.core.company.service.CompanyService;
import com.yeti.model.company.Company;
import com.yeti.model.util.Batch;

@RestController
@ExposesResourceFor(Company.class)
@RequestMapping(value = "/Companys", produces = "application/hal+json")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<Resource<Company>>> getAllCompanys() {
		List<Company> companys = companyService.getAllCompanies();
		if( companys != null ) {
			List<Resource<Company>> returnCompanys = new ArrayList<Resource<Company>>();
			for( Company company : companys ) {
				returnCompanys.add(getCompanyResource(company));
			}
			return ResponseEntity.ok(returnCompanys);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource<Company>> getCompany(@PathVariable Integer id) {
		Company company = companyService.getCompany(id);
		if( company == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(getCompanyResource(company));
		}
	}
	
	@PostMapping
	public ResponseEntity<Resource<Company>> addCompany(@RequestBody Company company, HttpServletRequest request ) {
		Company newCompany = companyService.addCompany(company);
		if( newCompany != null ) {
			String requestURI = request.getRequestURI();
			try {
				return ResponseEntity.created(new URI(requestURI + "/" + newCompany.getCompanyId())).build();		
			} catch( Exception e ) {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Resource<Company>> updateCompany(@RequestBody Company company, @PathVariable Integer id) {
		if( !companyService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			companyService.updateCompany(id, company);
			Company updatedCompany = companyService.updateCompany(id, company);
			if( updatedCompany != null ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Resource<Company>> deleteCompany(@PathVariable Integer id) {
		if( !companyService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			companyService.deleteCompany(id);
			if( !companyService.exists(id) ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@PatchMapping
	public void processBatchAction(@RequestBody Batch batch) {
		companyService.processBatchAction(batch);
	}
	
	private Resource<Company> getCompanyResource(Company a) {
	    Resource<Company> resource = new Resource<Company>(a);
	    resource.add(linkTo(methodOn(CompanyController.class).getCompany(a.getCompanyId())).withSelfRel());
	    return resource;
	}

}








