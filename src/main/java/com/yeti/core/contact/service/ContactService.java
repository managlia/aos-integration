package com.yeti.core.contact.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.core.contact.repository.ContactRepository;
import com.yeti.model.contact.Contact;
import com.yeti.model.util.Batch;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		contactRepository.findAll().forEach(contacts::add);
		return contacts;
	}
	
	public Contact getContact(Integer id) {
		return contactRepository.findOne(id);
	}
	
	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public Contact updateContact(Integer id, Contact contact) {
		return contactRepository.save(contact);
	}

	public void deleteContact(Integer id) {
		contactRepository.delete(id);
	}
	
	public void processBatchAction(Batch batch) {
		// TODO: Write logic for batch processing
	}
	
	public boolean exists(Integer id) {
		return contactRepository.exists(id);
	}
	
}
