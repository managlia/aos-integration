package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the contact_url_type database table.
 * 
 */
@Entity
@Table(name="contact_url_type")
@NamedQuery(name="ContactUrlType.findAll", query="SELECT c FROM ContactUrlType c")
public class ContactUrlType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_url_type_id")
	private String contactUrlTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="contact_url_type_create_date", insertable=false, updatable=false)
	private Date contactUrlTypeCreateDate;

	@Column(name="contact_url_type_description")
	private String contactUrlTypeDescription;

	@Column(name="contact_url_type_name")
	private String contactUrlTypeName;

	public ContactUrlType() {
	}

	public String getContactUrlTypeId() {
		return this.contactUrlTypeId;
	}

	public void setContactUrlTypeId(String contactUrlTypeId) {
		this.contactUrlTypeId = contactUrlTypeId;
	}

	public Date getContactUrlTypeCreateDate() {
		return this.contactUrlTypeCreateDate;
	}

	public void setContactUrlTypeCreateDate(Date contactUrlTypeCreateDate) {
		this.contactUrlTypeCreateDate = contactUrlTypeCreateDate;
	}

	public String getContactUrlTypeDescription() {
		return this.contactUrlTypeDescription;
	}

	public void setContactUrlTypeDescription(String contactUrlTypeDescription) {
		this.contactUrlTypeDescription = contactUrlTypeDescription;
	}

	public String getContactUrlTypeName() {
		return this.contactUrlTypeName;
	}

	public void setContactUrlTypeName(String contactUrlTypeName) {
		this.contactUrlTypeName = contactUrlTypeName;
	}

}