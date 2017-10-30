package com.yeti.core.types.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.ContactClassificationType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ContactClassificationType", path = "ContactClassificationTypes")
public interface ContactClassificationTypeRepository extends JpaRepository<ContactClassificationType, String> {  //Entity, Id

}
