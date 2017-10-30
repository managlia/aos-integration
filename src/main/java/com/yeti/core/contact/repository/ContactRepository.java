package com.yeti.core.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.Contact;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Contact", path = "Contacts")
public interface ContactRepository extends JpaRepository<Contact, Integer> {  //Entity, Id

}
