package com.yeti.core.types.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.company.CompanyAddressType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CompanyAddressType", path = "CompanyAddressTypes")
public interface CompanyAddressTypeRepository extends JpaRepository<CompanyAddressType, String> {  //Entity, Id

}
