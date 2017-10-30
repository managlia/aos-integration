package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Attachment;

import java.util.Date;


/**
 * The persistent class for the campaign_attachment database table.
 * 
 */
@Entity
@Table(name="campaign_attachment")
@NamedQuery(name="CampaignAttachment.findAll", query="SELECT c FROM CampaignAttachment c")
public class CampaignAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_attachment_id")
	private int campaignAttachmentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_attachment_create_date")
	private Date campaignAttachmentCreateDate;

	//bi-directional many-to-one association to Attachment
	@ManyToOne
	@JoinColumn(name="attachment_id")
	private Attachment attachment;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="campaign_id")
	@JsonBackReference 
	private Campaign campaign;

	public CampaignAttachment() {
	}

	public int getCampaignAttachmentId() {
		return this.campaignAttachmentId;
	}

	public void setCampaignAttachmentId(int campaignAttachmentId) {
		this.campaignAttachmentId = campaignAttachmentId;
	}

	public Date getCampaignAttachmentCreateDate() {
		return this.campaignAttachmentCreateDate;
	}

	public void setCampaignAttachmentCreateDate(Date campaignAttachmentCreateDate) {
		this.campaignAttachmentCreateDate = campaignAttachmentCreateDate;
	}

	public Attachment getAttachment() {
		return this.attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

}