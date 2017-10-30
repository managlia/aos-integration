package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Attachment;

import java.util.Date;


/**
 * The persistent class for the action_attachment database table.
 * 
 */
@Entity
@Table(name="action_attachment")
@NamedQuery(name="ActionAttachment.findAll", query="SELECT a FROM ActionAttachment a")
public class ActionAttachment extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_attachment_id")
	private int actionAttachmentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_attachment_create_date")
	private Date actionAttachmentCreateDate;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="action_id")
	@JsonBackReference
	private Action action;

	//bi-directional many-to-one association to Attachment
	@ManyToOne
	@JoinColumn(name="attachment_id")
	private Attachment attachment;

	public ActionAttachment() {
	}

	public int getActionAttachmentId() {
		return this.actionAttachmentId;
	}

	public void setActionAttachmentId(int actionAttachmentId) {
		this.actionAttachmentId = actionAttachmentId;
	}

	public Date getActionAttachmentCreateDate() {
		return this.actionAttachmentCreateDate;
	}

	public void setActionAttachmentCreateDate(Date actionAttachmentCreateDate) {
		this.actionAttachmentCreateDate = actionAttachmentCreateDate;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Attachment getAttachment() {
		return this.attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

}