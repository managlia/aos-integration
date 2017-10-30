package com.yeti.core.contact.controller;

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

import com.yeti.core.contact.service.ContactService;
import com.yeti.model.contact.Contact;
import com.yeti.model.util.Batch;

@RestController
@ExposesResourceFor(Contact.class)
@RequestMapping(value = "/Contacts", produces = "application/hal+json")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping
	public ResponseEntity<List<Resource<Contact>>> getAllContacts() {
		List<Contact> contacts = contactService.getAllContacts();
		if( contacts != null ) {
			List<Resource<Contact>> returnContacts = new ArrayList<Resource<Contact>>();
			for( Contact contact : contacts ) {
				returnContacts.add(getContactResource(contact));
			}
			return ResponseEntity.ok(returnContacts);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource<Contact>> getContact(@PathVariable Integer id) {
		Contact contact = contactService.getContact(id);
		if( contact == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(getContactResource(contact));
		}
	}
	
	@PostMapping
	public ResponseEntity<Resource<Contact>> addContact(@RequestBody Contact contact, HttpServletRequest request ) {
		Contact newContact = contactService.addContact(contact);
		if( newContact != null ) {
			String requestURI = request.getRequestURI();
			try {
				return ResponseEntity.created(new URI(requestURI + "/" + newContact.getContactId())).build();		
			} catch( Exception e ) {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Resource<Contact>> updateContact(@RequestBody Contact contact, @PathVariable Integer id) {
		if( !contactService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			contactService.updateContact(id, contact);
			Contact updatedContact = contactService.updateContact(id, contact);
			if( updatedContact != null ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Resource<Contact>> deleteContact(@PathVariable Integer id) {
		if( !contactService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			contactService.deleteContact(id);
			if( !contactService.exists(id) ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@PatchMapping
	public void processBatchAction(@RequestBody Batch batch) {
		contactService.processBatchAction(batch);
	}
	
	private Resource<Contact> getContactResource(Contact a) {
	    Resource<Contact> resource = new Resource<Contact>(a);
	    resource.add(linkTo(methodOn(ContactController.class).getContact(a.getContactId())).withSelfRel());
	    return resource;
	}

}








