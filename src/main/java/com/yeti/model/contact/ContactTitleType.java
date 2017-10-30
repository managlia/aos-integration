package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the contact_title_type database table.
 * 
 */
@Entity
@Table(name="contact_title_type")
@NamedQuery(name="ContactTitleType.findAll", query="SELECT c FROM ContactTitleType c")
public class ContactTitleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_title_type_id")
	private int contactTitleTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_title_type_create_date")
	private Date contactTitleTypeCreateDate;

	@Column(name="contact_title_type_description")
	private String contactTitleTypeDescription;

	@Column(name="contact_title_type_name")
	private String contactTitleTypeName;

	public ContactTitleType() {
	}

	public int getContactTitleTypeId() {
		return this.contactTitleTypeId;
	}

	public void setContactTitleTypeId(int contactTitleTypeId) {
		this.contactTitleTypeId = contactTitleTypeId;
	}

	public Date getContactTitleTypeCreateDate() {
		return this.contactTitleTypeCreateDate;
	}

	public void setContactTitleTypeCreateDate(Date contactTitleTypeCreateDate) {
		this.contactTitleTypeCreateDate = contactTitleTypeCreateDate;
	}

	public String getContactTitleTypeDescription() {
		return this.contactTitleTypeDescription;
	}

	public void setContactTitleTypeDescription(String contactTitleTypeDescription) {
		this.contactTitleTypeDescription = contactTitleTypeDescription;
	}

	public String getContactTitleTypeName() {
		return this.contactTitleTypeName;
	}

	public void setContactTitleTypeName(String contactTitleTypeName) {
		this.contactTitleTypeName = contactTitleTypeName;
	}

}