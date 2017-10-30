package com.yeti.core.action.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.Action;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Action", path = "Actions")
public interface ActionRepository extends JpaRepository<Action, Integer> {  //Entity, Id

	public List<Action> findByActionDescriptionIgnoreCaseContaining(String actionDescription);
	
	public List<Action> findByActionNameIgnoreCaseContaining(String actionName);

	@Query("SELECT a FROM Action a WHERE a.actionActive = :activeFlag")
	public List<Action> findUsingActiveFlag(@Param("activeFlag") Boolean activeFlag);
	
	
}
