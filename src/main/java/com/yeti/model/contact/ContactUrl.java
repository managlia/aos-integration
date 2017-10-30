package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the contact_url database table.
 * 
 */
@Entity
@Table(name="contact_url")
@NamedQuery(name="ContactUrl.findAll", query="SELECT c FROM ContactUrl c")
public class ContactUrl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_url_id")
	private int contactUrlId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_url_create_date")
	private Date contactUrlCreateDate;

	@Column(name="contact_url_description")
	private String contactUrlDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_url_last_modified_date")
	private Date contactUrlLastModifiedDate;

	@Column(name="contact_url_value")
	private String contactUrlValue;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonBackReference
	private Contact contact;

	//bi-directional many-to-one association to ContactUrlType
	@ManyToOne
	@JoinColumn(name="contact_url_type_id")
	private ContactUrlType contactUrlType;

	public ContactUrl() {
	}

	public int getContactUrlId() {
		return this.contactUrlId;
	}

	public void setContactUrlId(int contactUrlId) {
		this.contactUrlId = contactUrlId;
	}

	public Date getContactUrlCreateDate() {
		return this.contactUrlCreateDate;
	}

	public void setContactUrlCreateDate(Date contactUrlCreateDate) {
		this.contactUrlCreateDate = contactUrlCreateDate;
	}

	public String getContactUrlDescription() {
		return this.contactUrlDescription;
	}

	public void setContactUrlDescription(String contactUrlDescription) {
		this.contactUrlDescription = contactUrlDescription;
	}

	public Date getContactUrlLastModifiedDate() {
		return this.contactUrlLastModifiedDate;
	}

	public void setContactUrlLastModifiedDate(Date contactUrlLastModifiedDate) {
		this.contactUrlLastModifiedDate = contactUrlLastModifiedDate;
	}

	public String getContactUrlValue() {
		return this.contactUrlValue;
	}

	public void setContactUrlValue(String contactUrlValue) {
		this.contactUrlValue = contactUrlValue;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactUrlType getContactUrlType() {
		return this.contactUrlType;
	}

	public void setContactUrlType(ContactUrlType contactUrlType) {
		this.contactUrlType = contactUrlType;
	}

}