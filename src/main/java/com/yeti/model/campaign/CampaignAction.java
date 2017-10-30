package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.action.Action;
import java.util.Date;


/**
 * The persistent class for the campaign_action database table.
 * 
 */
@Entity
@Table(name="campaign_action")
@NamedQuery(name="CampaignAction.findAll", query="SELECT c FROM CampaignAction c")
public class CampaignAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_action_id")
	private int campaignActionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_action_linkage_date")
	private Date campaignActionLinkageDate;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="action_id")
	@JsonManagedReference
	private Action action;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="campaign_id")
	@JsonBackReference 
	private Campaign campaign;

	public CampaignAction() {
	}

	public int getCampaignActionId() {
		return this.campaignActionId;
	}

	public void setCampaignActionId(int campaignActionId) {
		this.campaignActionId = campaignActionId;
	}

	public Date getCampaignActionLinkageDate() {
		return this.campaignActionLinkageDate;
	}

	public void setCampaignActionLinkageDate(Date campaignActionLinkageDate) {
		this.campaignActionLinkageDate = campaignActionLinkageDate;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

}