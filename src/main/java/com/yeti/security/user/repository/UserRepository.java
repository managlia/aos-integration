package com.yeti.security.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.host.User;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "User", path = "Users")
public interface UserRepository extends JpaRepository<User, Integer> {  //Entity, Id


	
}
