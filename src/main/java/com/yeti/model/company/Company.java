package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.campaign.CampaignCompany;
import com.yeti.model.contact.Contact;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_id")
	private int companyId;

	@Column(name="company_active")
	private byte companyActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date companyCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_deactivation_date")
	private Date companyDeactivationDate;

	@Column(name="company_description")
	private String companyDescription;

	@Column(name="company_external_id")
	private String companyExternalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_last_modified_date", insertable=false, updatable=false)
	private Date companyLastModifiedDate;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_target_date")
	private Date companyTargetDate;

	@Column(name="company_valuation")
	private String companyValuation;

	//bi-directional many-to-one association to CampaignCompany
	@OneToMany(mappedBy="company")
	@RestResource(path = "CompanyCampaigns", rel="campaigns")
	@JsonIgnore
	private List<CampaignCompany> campaignCompanies;

	//bi-directional many-to-one association to CompanyClassificationType
	@ManyToOne
	@JoinColumn(name="company_classification_type_id")
	private CompanyClassificationType companyClassificationType;

	//bi-directional many-to-one association to CompanyAddress
	@OneToMany(mappedBy="company")
	@JsonManagedReference
	private List<CompanyAddress> companyAddresses;

	//bi-directional many-to-one association to CompanyAttachment
	@OneToMany(mappedBy="company")
	@JsonManagedReference
	private List<CompanyAttachment> companyAttachments;

	//bi-directional many-to-one association to CompanyTag
	@OneToMany(mappedBy="company")
	@JsonManagedReference
	private List<CompanyTag> companyTags;

	//bi-directional many-to-one association to CompanyUrl
	@OneToMany(mappedBy="company")
	@JsonManagedReference
	private List<CompanyUrl> companyUrls;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="company")
	@RestResource(path = "contacts", rel="contacts")
	@JsonIgnore
	private List<Contact> contacts;

	public Company() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public byte getCompanyActive() {
		return this.companyActive;
	}

	public void setCompanyActive(byte companyActive) {
		this.companyActive = companyActive;
	}

	public Date getCompanyCreateDate() {
		return this.companyCreateDate;
	}

	public void setCompanyCreateDate(Date companyCreateDate) {
		this.companyCreateDate = companyCreateDate;
	}

	public Date getCompanyDeactivationDate() {
		return this.companyDeactivationDate;
	}

	public void setCompanyDeactivationDate(Date companyDeactivationDate) {
		this.companyDeactivationDate = companyDeactivationDate;
	}

	public String getCompanyDescription() {
		return this.companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getCompanyExternalId() {
		return this.companyExternalId;
	}

	public void setCompanyExternalId(String companyExternalId) {
		this.companyExternalId = companyExternalId;
	}

	public Date getCompanyLastModifiedDate() {
		return this.companyLastModifiedDate;
	}

	public void setCompanyLastModifiedDate(Date companyLastModifiedDate) {
		this.companyLastModifiedDate = companyLastModifiedDate;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCompanyTargetDate() {
		return this.companyTargetDate;
	}

	public void setCompanyTargetDate(Date companyTargetDate) {
		this.companyTargetDate = companyTargetDate;
	}

	public String getCompanyValuation() {
		return this.companyValuation;
	}

	public void setCompanyValuation(String companyValuation) {
		this.companyValuation = companyValuation;
	}

	public List<CampaignCompany> getCampaignCompanies() {
		return this.campaignCompanies;
	}

	public void setCampaignCompanies(List<CampaignCompany> campaignCompanies) {
		this.campaignCompanies = campaignCompanies;
	}

	public CompanyClassificationType getCompanyClassificationType() {
		return this.companyClassificationType;
	}

	public void setCompanyClassificationType(CompanyClassificationType companyClassificationType) {
		this.companyClassificationType = companyClassificationType;
	}

	public List<CompanyAddress> getCompanyAddresses() {
		return this.companyAddresses;
	}

	public void setCompanyAddresses(List<CompanyAddress> companyAddresses) {
		this.companyAddresses = companyAddresses;
	}

	public List<CompanyAttachment> getCompanyAttachments() {
		return this.companyAttachments;
	}

	public void setCompanyAttachments(List<CompanyAttachment> companyAttachments) {
		this.companyAttachments = companyAttachments;
	}

	public List<CompanyTag> getCompanyTags() {
		return this.companyTags;
	}

	public void setCompanyTags(List<CompanyTag> companyTags) {
		this.companyTags = companyTags;
	}

	public List<CompanyUrl> getCompanyUrls() {
		return this.companyUrls;
	}

	public void setCompanyUrls(List<CompanyUrl> companyUrls) {
		this.companyUrls = companyUrls;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}