package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the contact_address_type database table.
 * 
 */
@Entity
@Table(name="contact_address_type")
@NamedQuery(name="ContactAddressType.findAll", query="SELECT c FROM ContactAddressType c")
public class ContactAddressType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_address_type_id")
	private String contactAddressTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="contact_address_type_create_date", insertable=false, updatable=false)
	private Date contactAddressTypeCreateDate;

	@Column(name="contact_address_type_description")
	private String contactAddressTypeDescription;

	@Column(name="contact_address_type_name")
	private String contactAddressTypeName;

	public ContactAddressType() {
	}

	public String getContactAddressTypeId() {
		return this.contactAddressTypeId;
	}

	public void setContactAddressTypeId(String contactAddressTypeId) {
		this.contactAddressTypeId = contactAddressTypeId;
	}

	public Date getContactAddressTypeCreateDate() {
		return this.contactAddressTypeCreateDate;
	}

	public void setContactAddressTypeCreateDate(Date contactAddressTypeCreateDate) {
		this.contactAddressTypeCreateDate = contactAddressTypeCreateDate;
	}

	public String getContactAddressTypeDescription() {
		return this.contactAddressTypeDescription;
	}

	public void setContactAddressTypeDescription(String contactAddressTypeDescription) {
		this.contactAddressTypeDescription = contactAddressTypeDescription;
	}

	public String getContactAddressTypeName() {
		return this.contactAddressTypeName;
	}

	public void setContactAddressTypeName(String contactAddressTypeName) {
		this.contactAddressTypeName = contactAddressTypeName;
	}


}