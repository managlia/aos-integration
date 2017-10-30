package com.yeti.core.action.controller;

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

import com.yeti.core.action.service.ReminderService;
import com.yeti.model.action.Reminder;
import com.yeti.model.util.Batch;

@RestController
@ExposesResourceFor(Reminder.class)
@RequestMapping(value = "/Reminders", produces = "application/hal+json")
public class ReminderController {

	@Autowired
	private ReminderService reminderService;

	@GetMapping
	public ResponseEntity<List<Resource<Reminder>>> getAllReminders() {
		List<Reminder> reminders = reminderService.getAllReminders();
		if( reminders != null ) {
			List<Resource<Reminder>> returnReminders = new ArrayList<Resource<Reminder>>();
			for( Reminder reminder : reminders ) {
				returnReminders.add(getReminderResource(reminder));
			}
			return ResponseEntity.ok(returnReminders);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource<Reminder>> getReminder(@PathVariable Integer id) {
		Reminder reminder = reminderService.getReminder(id);
		if( reminder == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(getReminderResource(reminder));
		}
	}
	
	@PostMapping
	public ResponseEntity<Resource<Reminder>> addReminder(@RequestBody Reminder reminder, HttpServletRequest request ) {
		Reminder newReminder = reminderService.addReminder(reminder);
		if( newReminder != null ) {
			String requestURI = request.getRequestURI();
			try {
				return ResponseEntity.created(new URI(requestURI + "/" + newReminder.getActionId())).build();		
			} catch( Exception e ) {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Resource<Reminder>> updateReminder(@RequestBody Reminder reminder, @PathVariable Integer id) {
		if( !reminderService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			reminderService.updateReminder(id, reminder);
			Reminder updatedReminder = reminderService.updateReminder(id, reminder);
			if( updatedReminder != null ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Resource<Reminder>> deleteReminder(@PathVariable Integer id) {
		if( !reminderService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			reminderService.deleteReminder(id);
			if( !reminderService.exists(id) ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@PatchMapping
	public void processBatch(@RequestBody Batch batch) {
		reminderService.processBatch(batch);
	}

	private Resource<Reminder> getReminderResource(Reminder a) {
	    Resource<Reminder> resource = new Resource<Reminder>(a);
	    resource.add(linkTo(methodOn(ReminderController.class).getReminder(a.getActionId())).withSelfRel());
	    return resource;
	}

}








