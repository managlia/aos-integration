package com.yeti.core.action.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.Reminder;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Reminder", path = "Reminders")
public interface ReminderRepository extends JpaRepository<Reminder, Integer> {  //Entity, Id


}
