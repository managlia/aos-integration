package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the contact_address database table.
 * 
 */
@Entity
@Table(name="contact_address")
@NamedQuery(name="ContactAddress.findAll", query="SELECT c FROM ContactAddress c")
public class ContactAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_address_id")
	private int contactAddressId;

	@Column(name="contact_address_1")
	private String contactAddress1;

	@Column(name="contact_address_2")
	private String contactAddress2;

	@Column(name="contact_city")
	private String contactCity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_city_create_date")
	private Date contactCityCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_city_last_modified_date")
	private Date contactCityLastModifiedDate;

	@Column(name="contact_country")
	private String contactCountry;

	@Column(name="contact_postal_code")
	private String contactPostalCode;

	@Column(name="contact_state")
	private String contactState;

	//bi-directional many-to-one association to ContactAddressType
	@ManyToOne
	@JoinColumn(name="contact_address_type_id")
	private ContactAddressType contactAddressType;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonBackReference
	private Contact contact;

	public ContactAddress() {
	}

	public int getContactAddressId() {
		return this.contactAddressId;
	}

	public void setContactAddressId(int contactAddressId) {
		this.contactAddressId = contactAddressId;
	}

	public String getContactAddress1() {
		return this.contactAddress1;
	}

	public void setContactAddress1(String contactAddress1) {
		this.contactAddress1 = contactAddress1;
	}

	public String getContactAddress2() {
		return this.contactAddress2;
	}

	public void setContactAddress2(String contactAddress2) {
		this.contactAddress2 = contactAddress2;
	}

	public String getContactCity() {
		return this.contactCity;
	}

	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}

	public Date getContactCityCreateDate() {
		return this.contactCityCreateDate;
	}

	public void setContactCityCreateDate(Date contactCityCreateDate) {
		this.contactCityCreateDate = contactCityCreateDate;
	}

	public Date getContactCityLastModifiedDate() {
		return this.contactCityLastModifiedDate;
	}

	public void setContactCityLastModifiedDate(Date contactCityLastModifiedDate) {
		this.contactCityLastModifiedDate = contactCityLastModifiedDate;
	}

	public String getContactCountry() {
		return this.contactCountry;
	}

	public void setContactCountry(String contactCountry) {
		this.contactCountry = contactCountry;
	}

	public String getContactPostalCode() {
		return this.contactPostalCode;
	}

	public void setContactPostalCode(String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}

	public String getContactState() {
		return this.contactState;
	}

	public void setContactState(String contactState) {
		this.contactState = contactState;
	}

	public ContactAddressType getContactAddressType() {
		return this.contactAddressType;
	}

	public void setContactAddressType(ContactAddressType contactAddressType) {
		this.contactAddressType = contactAddressType;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}