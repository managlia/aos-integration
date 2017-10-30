package com.yeti.model.campaign;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the campaign_classification_type database table.
 * 
 */
@Entity
@Table(name="campaign_classification_type")
@NamedQuery(name="CampaignClassificationType.findAll", query="SELECT c FROM CampaignClassificationType c")
public class CampaignClassificationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_classification_type_id", insertable=false, updatable=false)
	private int campaignClassificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_classification_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date campaignClassificationTypeCreateDate;

	@Column(name="campaign_classification_type_description")
	private String campaignClassificationTypeDescription;

	@Column(name="campaign_classification_type_name", insertable=true, updatable=true)
	private String campaignClassificationTypeName;

	public CampaignClassificationType() {
	}

	public int getCampaignClassificationTypeId() {
		return this.campaignClassificationTypeId;
	}

	public void setCampaignClassificationTypeId(int campaignClassificationTypeId) {
		this.campaignClassificationTypeId = campaignClassificationTypeId;
	}

	public Date getCampaignClassificationTypeCreateDate() {
		return this.campaignClassificationTypeCreateDate;
	}

	public void setCampaignClassificationTypeCreateDate(Date campaignClassificationTypeCreateDate) {
		this.campaignClassificationTypeCreateDate = campaignClassificationTypeCreateDate;
	}

	public String getCampaignClassificationTypeDescription() {
		return this.campaignClassificationTypeDescription;
	}

	public void setCampaignClassificationTypeDescription(String campaignClassificationTypeDescription) {
		this.campaignClassificationTypeDescription = campaignClassificationTypeDescription;
	}

	public String getCampaignClassificationTypeName() {
		return this.campaignClassificationTypeName;
	}

	public void setCampaignClassificationTypeName(String campaignClassificationTypeName) {
		this.campaignClassificationTypeName = campaignClassificationTypeName;
	}

}