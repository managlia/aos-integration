package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Attachment;

import java.util.Date;


/**
 * The persistent class for the company_attachment database table.
 * 
 */
@Entity
@Table(name="company_attachment")
@NamedQuery(name="CompanyAttachment.findAll", query="SELECT c FROM CompanyAttachment c")
public class CompanyAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_attachment_id")
	private int companyAttachmentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_attachment_create_date", insertable=false, updatable=false)
	private Date companyAttachmentCreateDate;

	//bi-directional many-to-one association to Attachment
	@ManyToOne
	@JoinColumn(name="attachment_id")
	private Attachment attachment;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference
	private Company company;

	public CompanyAttachment() {
	}

	public int getCompanyAttachmentId() {
		return this.companyAttachmentId;
	}

	public void setCompanyAttachmentId(int companyAttachmentId) {
		this.companyAttachmentId = companyAttachmentId;
	}

	public Date getCompanyAttachmentCreateDate() {
		return this.companyAttachmentCreateDate;
	}

	public void setCompanyAttachmentCreateDate(Date companyAttachmentCreateDate) {
		this.companyAttachmentCreateDate = companyAttachmentCreateDate;
	}

	public Attachment getAttachment() {
		return this.attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}