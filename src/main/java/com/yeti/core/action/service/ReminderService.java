package com.yeti.core.action.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.core.action.repository.ReminderRepository;
import com.yeti.model.action.Reminder;
import com.yeti.model.util.Batch;

@Service
public class ReminderService {
	
	@Autowired
	private ReminderRepository reminderRepository;
	
	public List<Reminder> getAllReminders() {
		List<Reminder> reminders = new ArrayList<Reminder>();
		reminderRepository.findAll().forEach(reminders::add);
		return reminders;
	}
	
	public Reminder getReminder(Integer id) {
		return reminderRepository.findOne(id);
	}
	
	public Reminder addReminder(Reminder reminder) {
		return reminderRepository.save(reminder);
	}

	public Reminder updateReminder(Integer id, Reminder reminder) {
		return reminderRepository.save(reminder);
	}

	public void deleteReminder(Integer id) {
		reminderRepository.delete(id);
	}
	
	public void processBatch(Batch batch) {
		// TODO: Write logic for batch processing
	}
	
	public boolean exists(Integer id) {
		return reminderRepository.exists(id);
	}
	
}
