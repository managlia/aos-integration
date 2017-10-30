package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yeti.model.contact.Contact;

import java.util.Date;


/**
 * The persistent class for the campaign_contact database table.
 * 
 */
@Entity
@Table(name="campaign_contact")
@NamedQuery(name="CampaignContact.findAll", query="SELECT c FROM CampaignContact c")
public class CampaignContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_contact_id")
	private int campaignContactId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_contact_linkage_date")
	private Date campaignContactLinkageDate;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="campaign_id")
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class, 
			  property = "campaignId")
	private Campaign campaign;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id")
	@JsonIgnore
	private Contact contact;

	public CampaignContact() {
	}

	public int getCampaignContactId() {
		return this.campaignContactId;
	}

	public void setCampaignContactId(int campaignContactId) {
		this.campaignContactId = campaignContactId;
	}

	public Date getCampaignContactLinkageDate() {
		return this.campaignContactLinkageDate;
	}

	public void setCampaignContactLinkageDate(Date campaignContactLinkageDate) {
		this.campaignContactLinkageDate = campaignContactLinkageDate;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}