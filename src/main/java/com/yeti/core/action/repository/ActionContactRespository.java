package com.yeti.core.action.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.ActionContact;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ActionContact", path = "ActionContacts")
public interface ActionContactRespository extends JpaRepository<ActionContact, Integer> {  //Entity, Id


}