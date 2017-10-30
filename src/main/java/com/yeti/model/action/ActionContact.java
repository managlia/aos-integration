package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yeti.model.contact.Contact;

import java.util.Date;


/**
 * The persistent class for the action_contact database table.
 * 
 */
@Entity
@Table(name="action_contact")
@NamedQuery(name="ActionContact.findAll", query="SELECT a FROM ActionContact a")
public class ActionContact extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_contact_id")
	private int actionContactId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_contact_linkage_date")
	private Date actionContactLinkageDate;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="action_id")
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "actionId")
	private Action action;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonBackReference
	private Contact contact;

	public ActionContact() {
	}

	public int getActionContactId() {
		return this.actionContactId;
	}

	public void setActionContactId(int actionContactId) {
		this.actionContactId = actionContactId;
	}

	public Date getActionContactLinkageDate() {
		return this.actionContactLinkageDate;
	}

	public void setActionContactLinkageDate(Date actionContactLinkageDate) {
		this.actionContactLinkageDate = actionContactLinkageDate;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}