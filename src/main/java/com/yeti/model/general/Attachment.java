package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the attachment database table.
 * 
 */
@Entity
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="attachment_id")
	private int attachmentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="attachment_create_date")
	private Date attachmentCreateDate;

	@Lob
	@Column(name="attachment_file")
	private byte[] attachmentFile;

	@Column(name="attachment_name")
	private String attachmentName;

	@Column(name="attachment_path")
	private String attachmentPath;

	@Column(name="attachment_type")
	private String attachmentType;

	public Attachment() {
	}

	public int getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Date getAttachmentCreateDate() {
		return this.attachmentCreateDate;
	}

	public void setAttachmentCreateDate(Date attachmentCreateDate) {
		this.attachmentCreateDate = attachmentCreateDate;
	}

	public byte[] getAttachmentFile() {
		return this.attachmentFile;
	}

	public void setAttachmentFile(byte[] attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentType() {
		return this.attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

}