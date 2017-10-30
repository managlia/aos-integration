package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Tag;

import java.util.Date;


/**
 * The persistent class for the contact_tag database table.
 * 
 */
@Entity
@Table(name="contact_tag")
@NamedQuery(name="ContactTag.findAll", query="SELECT c FROM ContactTag c")
public class ContactTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_tag_id")
	private int contactTagId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_tag_linkage_date")
	private Date contactTagLinkageDate;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonBackReference
	private Contact contact;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tag tag;

	public ContactTag() {
	}

	public int getContactTagId() {
		return this.contactTagId;
	}

	public void setContactTagId(int contactTagId) {
		this.contactTagId = contactTagId;
	}

	public Date getContactTagLinkageDate() {
		return this.contactTagLinkageDate;
	}

	public void setContactTagLinkageDate(Date contactTagLinkageDate) {
		this.contactTagLinkageDate = contactTagLinkageDate;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}