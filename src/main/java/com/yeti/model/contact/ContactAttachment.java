package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Attachment;

import java.util.Date;


/**
 * The persistent class for the contact_attachment database table.
 * 
 */
@Entity
@Table(name="contact_attachment")
@NamedQuery(name="ContactAttachment.findAll", query="SELECT c FROM ContactAttachment c")
public class ContactAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_attachment_id")
	private int contactAttachmentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_attachment_create_date")
	private Date contactAttachmentCreateDate;

	//bi-directional many-to-one association to Attachment
	@ManyToOne
	@JoinColumn(name="attachment_id")
	private Attachment attachment;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonBackReference
	private Contact contact;

	public ContactAttachment() {
	}

	public int getContactAttachmentId() {
		return this.contactAttachmentId;
	}

	public void setContactAttachmentId(int contactAttachmentId) {
		this.contactAttachmentId = contactAttachmentId;
	}

	public Date getContactAttachmentCreateDate() {
		return this.contactAttachmentCreateDate;
	}

	public void setContactAttachmentCreateDate(Date contactAttachmentCreateDate) {
		this.contactAttachmentCreateDate = contactAttachmentCreateDate;
	}

	public Attachment getAttachment() {
		return this.attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}