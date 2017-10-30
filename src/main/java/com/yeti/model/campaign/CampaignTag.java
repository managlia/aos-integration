package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Tag;

import java.util.Date;


/**
 * The persistent class for the campaign_tag database table.
 * 
 */
@Entity
@Table(name="campaign_tag")
@NamedQuery(name="CampaignTag.findAll", query="SELECT c FROM CampaignTag c")
public class CampaignTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_tag_id")
	private int campaignTagId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_tag_linkage_date")
	private Date campaignTagLinkageDate;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="campaign_id")
	@JsonBackReference 
	private Campaign campaign;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tag tag;

	public CampaignTag() {
	}

	public int getCampaignTagId() {
		return this.campaignTagId;
	}

	public void setCampaignTagId(int campaignTagId) {
		this.campaignTagId = campaignTagId;
	}

	public Date getCampaignTagLinkageDate() {
		return this.campaignTagLinkageDate;
	}

	public void setCampaignTagLinkageDate(Date campaignTagLinkageDate) {
		this.campaignTagLinkageDate = campaignTagLinkageDate;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}