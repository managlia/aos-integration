package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.company.Company;

import java.util.Date;


/**
 * The persistent class for the campaign_company database table.
 * 
 */
@Entity
@Table(name="campaign_company")
@NamedQuery(name="CampaignCompany.findAll", query="SELECT c FROM CampaignCompany c")
public class CampaignCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_company_id")
	private int campaignCompanyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_company_linkage_date")
	private Date campaignCompanyLinkageDate;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="campaign_id")
	@JsonManagedReference
	private Campaign campaign;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference
	private Company company;

	public CampaignCompany() {
	}

	public int getCampaignCompanyId() {
		return this.campaignCompanyId;
	}

	public void setCampaignCompanyId(int campaignCompanyId) {
		this.campaignCompanyId = campaignCompanyId;
	}

	public Date getCampaignCompanyLinkageDate() {
		return this.campaignCompanyLinkageDate;
	}

	public void setCampaignCompanyLinkageDate(Date campaignCompanyLinkageDate) {
		this.campaignCompanyLinkageDate = campaignCompanyLinkageDate;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}