package com.yeti.core.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.company.Company;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Company", path = "Companies")
public interface CompanyRepository extends JpaRepository<Company, Integer> {  //Entity, Id

}
