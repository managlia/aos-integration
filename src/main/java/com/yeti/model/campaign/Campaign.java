package com.yeti.model.campaign;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.general.ScopeType;
import com.yeti.model.host.User;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the campaign database table.
 * 
 */
@Entity
@NamedQuery(name="Campaign.findAll", query="SELECT c FROM Campaign c")
public class Campaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_id")
	private int campaignId;

	@Column(name="campaign_active")
	private byte campaignActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_actual_completion_date")
	private Date campaignActualCompletionDate;

	@Column(name="campaign_actual_valuation")
	private String campaignActualValuation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_create_date")
	private Date campaignCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_deactivation_date")
	private Date campaignDeactivationDate;

	@Column(name="campaign_description")
	private String campaignDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_last_modified_date")
	private Date campaignLastModifiedDate;

	@Column(name="campaign_name")
	private String campaignName;

	@Column(name="campaign_restrict_to_owner")
	private byte campaignRestrictToOwner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="campaign_target_completion_date")
	private Date campaignTargetCompletionDate;

	@Column(name="campaign_target_valuation")
	private String campaignTargetValuation;

	//bi-directional many-to-one association to CampaignClassificationType
	@ManyToOne
	@JoinColumn(name="campaign_classification_type_id")
	private CampaignClassificationType campaignClassificationType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="campaign_owner_id")
	@JsonBackReference 
	private User user;

	//bi-directional many-to-one association to ScopeType
	@ManyToOne
	@JoinColumn(name="scope_type_id")
	private ScopeType scopeType;

	//bi-directional many-to-one association to CampaignAction
	@OneToMany(mappedBy="campaign")
	@RestResource(path = "campaignActions", rel="actions")
	@JsonIgnore
	private List<CampaignAction> campaignActions;

	//bi-directional many-to-one association to CampaignAttachment
	@OneToMany(mappedBy="campaign")
	@JsonManagedReference
	private List<CampaignAttachment> campaignAttachments;

	//bi-directional many-to-one association to CampaignCompany
	@OneToMany(mappedBy="campaign")
	@JsonBackReference 
	private List<CampaignCompany> campaignCompanies;

	//bi-directional many-to-one association to CampaignContact
	@OneToMany(mappedBy="campaign")
	@RestResource(path = "campaignContacts", rel="contacts")
	@JsonIgnore
	private List<CampaignContact> campaignContacts;

	//bi-directional many-to-one association to CampaignTag
	@OneToMany(mappedBy="campaign")
	@JsonManagedReference
	private List<CampaignTag> campaignTags;

	public Campaign() {
	}

	public int getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public byte getCampaignActive() {
		return this.campaignActive;
	}

	public void setCampaignActive(byte campaignActive) {
		this.campaignActive = campaignActive;
	}

	public Date getCampaignActualCompletionDate() {
		return this.campaignActualCompletionDate;
	}

	public void setCampaignActualCompletionDate(Date campaignActualCompletionDate) {
		this.campaignActualCompletionDate = campaignActualCompletionDate;
	}

	public String getCampaignActualValuation() {
		return this.campaignActualValuation;
	}

	public void setCampaignActualValuation(String campaignActualValuation) {
		this.campaignActualValuation = campaignActualValuation;
	}

	public Date getCampaignCreateDate() {
		return this.campaignCreateDate;
	}

	public void setCampaignCreateDate(Date campaignCreateDate) {
		this.campaignCreateDate = campaignCreateDate;
	}

	public Date getCampaignDeactivationDate() {
		return this.campaignDeactivationDate;
	}

	public void setCampaignDeactivationDate(Date campaignDeactivationDate) {
		this.campaignDeactivationDate = campaignDeactivationDate;
	}

	public String getCampaignDescription() {
		return this.campaignDescription;
	}

	public void setCampaignDescription(String campaignDescription) {
		this.campaignDescription = campaignDescription;
	}

	public Date getCampaignLastModifiedDate() {
		return this.campaignLastModifiedDate;
	}

	public void setCampaignLastModifiedDate(Date campaignLastModifiedDate) {
		this.campaignLastModifiedDate = campaignLastModifiedDate;
	}

	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public byte getCampaignRestrictToOwner() {
		return this.campaignRestrictToOwner;
	}

	public void setCampaignRestrictToOwner(byte campaignRestrictToOwner) {
		this.campaignRestrictToOwner = campaignRestrictToOwner;
	}

	public Date getCampaignTargetCompletionDate() {
		return this.campaignTargetCompletionDate;
	}

	public void setCampaignTargetCompletionDate(Date campaignTargetCompletionDate) {
		this.campaignTargetCompletionDate = campaignTargetCompletionDate;
	}

	public String getCampaignTargetValuation() {
		return this.campaignTargetValuation;
	}

	public void setCampaignTargetValuation(String campaignTargetValuation) {
		this.campaignTargetValuation = campaignTargetValuation;
	}

	public CampaignClassificationType getCampaignClassificationType() {
		return this.campaignClassificationType;
	}

	public void setCampaignClassificationType(CampaignClassificationType campaignClassificationType) {
		this.campaignClassificationType = campaignClassificationType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ScopeType getScopeType() {
		return this.scopeType;
	}

	public void setScopeType(ScopeType scopeType) {
		this.scopeType = scopeType;
	}

	public List<CampaignAction> getCampaignActions() {
		return this.campaignActions;
	}

	public void setCampaignActions(List<CampaignAction> campaignActions) {
		this.campaignActions = campaignActions;
	}

	public CampaignAction addCampaignAction(CampaignAction campaignAction) {
		getCampaignActions().add(campaignAction);
		campaignAction.setCampaign(this);

		return campaignAction;
	}

	public CampaignAction removeCampaignAction(CampaignAction campaignAction) {
		getCampaignActions().remove(campaignAction);
		campaignAction.setCampaign(null);

		return campaignAction;
	}

	public List<CampaignAttachment> getCampaignAttachments() {
		return this.campaignAttachments;
	}

	public void setCampaignAttachments(List<CampaignAttachment> campaignAttachments) {
		this.campaignAttachments = campaignAttachments;
	}

	public CampaignAttachment addCampaignAttachment(CampaignAttachment campaignAttachment) {
		getCampaignAttachments().add(campaignAttachment);
		campaignAttachment.setCampaign(this);

		return campaignAttachment;
	}

	public CampaignAttachment removeCampaignAttachment(CampaignAttachment campaignAttachment) {
		getCampaignAttachments().remove(campaignAttachment);
		campaignAttachment.setCampaign(null);

		return campaignAttachment;
	}

	public List<CampaignCompany> getCampaignCompanies() {
		return this.campaignCompanies;
	}

	public void setCampaignCompanies(List<CampaignCompany> campaignCompanies) {
		this.campaignCompanies = campaignCompanies;
	}

	public CampaignCompany addCampaignCompany(CampaignCompany campaignCompany) {
		getCampaignCompanies().add(campaignCompany);
		campaignCompany.setCampaign(this);

		return campaignCompany;
	}

	public CampaignCompany removeCampaignCompany(CampaignCompany campaignCompany) {
		getCampaignCompanies().remove(campaignCompany);
		campaignCompany.setCampaign(null);

		return campaignCompany;
	}

	public List<CampaignContact> getCampaignContacts() {
		return this.campaignContacts;
	}

	public void setCampaignContacts(List<CampaignContact> campaignContacts) {
		this.campaignContacts = campaignContacts;
	}

	public CampaignContact addCampaignContact(CampaignContact campaignContact) {
		getCampaignContacts().add(campaignContact);
		campaignContact.setCampaign(this);

		return campaignContact;
	}

	public CampaignContact removeCampaignContact(CampaignContact campaignContact) {
		getCampaignContacts().remove(campaignContact);
		campaignContact.setCampaign(null);

		return campaignContact;
	}

	public List<CampaignTag> getCampaignTags() {
		return this.campaignTags;
	}

	public void setCampaignTags(List<CampaignTag> campaignTags) {
		this.campaignTags = campaignTags;
	}

	public CampaignTag addCampaignTag(CampaignTag campaignTag) {
		getCampaignTags().add(campaignTag);
		campaignTag.setCampaign(this);

		return campaignTag;
	}

	public CampaignTag removeCampaignTag(CampaignTag campaignTag) {
		getCampaignTags().remove(campaignTag);
		campaignTag.setCampaign(null);

		return campaignTag;
	}

}