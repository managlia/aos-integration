package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;


/**
 * The persistent class for the reminder database table.
 * 
 */
@Entity
@NamedQuery(name="Reminder.findAll", query="SELECT r FROM Reminder r")
public class Reminder extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id")
	private int actionId;

	@Column(name="reminder_external_id")
	private String reminderExternalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reminder_last_retrieved_date")
	private Date reminderLastRetrievedDate;

	@Lob
	@Column(name="reminder_last_retrieved_value")
	private String reminderLastRetrievedValue;

	//bi-directional one-to-one association to Action
	@OneToOne
	@JoinColumn(name="action_id")
	private Action action;

	public Reminder() {
	}

	public int getActionId() {
		return this.actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getReminderExternalId() {
		return this.reminderExternalId;
	}

	public void setReminderExternalId(String reminderExternalId) {
		this.reminderExternalId = reminderExternalId;
	}

	public Date getReminderLastRetrievedDate() {
		return this.reminderLastRetrievedDate;
	}

	public void setReminderLastRetrievedDate(Date reminderLastRetrievedDate) {
		this.reminderLastRetrievedDate = reminderLastRetrievedDate;
	}

	public String getReminderLastRetrievedValue() {
		return this.reminderLastRetrievedValue;
	}

	public void setReminderLastRetrievedValue(String reminderLastRetrievedValue) {
		this.reminderLastRetrievedValue = reminderLastRetrievedValue;
	}
	
	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}