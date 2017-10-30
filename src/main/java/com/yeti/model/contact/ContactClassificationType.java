package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the contact_classification_type database table.
 * 
 */
@Entity
@Table(name="contact_classification_type")
@NamedQuery(name="ContactClassificationType.findAll", query="SELECT c FROM ContactClassificationType c")
public class ContactClassificationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_classification_type_id")
	private String contactClassificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_classification_type_create_date")
	@JsonIgnore
	private Date contactClassificationTypeCreateDate;

	@Column(name="contact_classification_type_description")
	private String contactClassificationTypeDescription;

	@Column(name="contact_classification_type_name")
	private String contactClassificationTypeName;

	public ContactClassificationType() {
	}

	public String getContactClassificationTypeId() {
		return this.contactClassificationTypeId;
	}

	public void setContactClassificationTypeId(String contactClassificationTypeId) {
		this.contactClassificationTypeId = contactClassificationTypeId;
	}

	public Date getContactClassificationTypeCreateDate() {
		return this.contactClassificationTypeCreateDate;
	}

	public void setContactClassificationTypeCreateDate(Date contactClassificationTypeCreateDate) {
		this.contactClassificationTypeCreateDate = contactClassificationTypeCreateDate;
	}

	public String getContactClassificationTypeDescription() {
		return this.contactClassificationTypeDescription;
	}

	public void setContactClassificationTypeDescription(String contactClassificationTypeDescription) {
		this.contactClassificationTypeDescription = contactClassificationTypeDescription;
	}

	public String getContactClassificationTypeName() {
		return this.contactClassificationTypeName;
	}

	public void setContactClassificationTypeName(String contactClassificationTypeName) {
		this.contactClassificationTypeName = contactClassificationTypeName;
	}

}