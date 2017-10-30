package com.yeti.model.contact;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yeti.model.action.ActionContact;
import com.yeti.model.campaign.CampaignContact;
import com.yeti.model.company.Company;
import com.yeti.model.host.User;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_id")
	private int contactId;

	@Column(name="contact_active")
	private byte contactActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_create_date")
	private Date contactCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_deactivation_date")
	private Date contactDeactivationDate;

	@Column(name="contact_description")
	private String contactDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_dob")
	private Date contactDob;

	@Column(name="contact_email_address")
	private String contactEmailAddress;

	@Column(name="contact_first_name")
	private String contactFirstName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contact_last_modified_date")
	private Date contactLastModifiedDate;

	@Column(name="contact_last_name")
	private String contactLastName;

	@Column(name="contact_valuation")
	private String contactValuation;

	//bi-directional many-to-one association to ActionContact
	@OneToMany(mappedBy="contact")
	@RestResource(path = "actionContacts", rel="contacts")
	@JsonIgnore
	private List<ActionContact> actionContacts;

	//bi-directional many-to-one association to CampaignContact
	@OneToMany(mappedBy="contact")
	@RestResource(path = "campaignContacts", rel="contacts")
	@JsonIgnore
	private List<CampaignContact> campaignContacts;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference
	private Company company;

	//bi-directional many-to-one association to ContactClassificationType
	@ManyToOne
	@JoinColumn(name="contact_classification_type_id")
	private ContactClassificationType contactClassificationType;

	//bi-directional many-to-one association to ContactTitleType
	@ManyToOne
	@JoinColumn(name="contact_title_type_id")
	private ContactTitleType contactTitleType;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="contact")
	@JsonIgnore
	private User user;
	
	//bi-directional many-to-one association to ContactAddress
	@OneToMany(mappedBy="contact")
	@JsonManagedReference
	private List<ContactAddress> contactAddresses;

	//bi-directional many-to-one association to ContactAttachment
	@OneToMany(mappedBy="contact")
	@JsonManagedReference
	private List<ContactAttachment> contactAttachments;

	//bi-directional many-to-one association to ContactTag
	@OneToMany(mappedBy="contact")
	@JsonManagedReference
	private List<ContactTag> contactTags;

	//bi-directional many-to-one association to ContactUrl
	@OneToMany(mappedBy="contact")
	@JsonManagedReference
	private List<ContactUrl> contactUrls;
	
	public Contact() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public byte getContactActive() {
		return this.contactActive;
	}

	public void setContactActive(byte contactActive) {
		this.contactActive = contactActive;
	}

	public Date getContactCreateDate() {
		return this.contactCreateDate;
	}

	public void setContactCreateDate(Date contactCreateDate) {
		this.contactCreateDate = contactCreateDate;
	}

	public Date getContactDeactivationDate() {
		return this.contactDeactivationDate;
	}

	public void setContactDeactivationDate(Date contactDeactivationDate) {
		this.contactDeactivationDate = contactDeactivationDate;
	}

	public String getContactDescription() {
		return this.contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public Date getContactDob() {
		return this.contactDob;
	}

	public void setContactDob(Date contactDob) {
		this.contactDob = contactDob;
	}

	public String getContactEmailAddress() {
		return this.contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public String getContactFirstName() {
		return this.contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public Date getContactLastModifiedDate() {
		return this.contactLastModifiedDate;
	}

	public void setContactLastModifiedDate(Date contactLastModifiedDate) {
		this.contactLastModifiedDate = contactLastModifiedDate;
	}

	public String getContactLastName() {
		return this.contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactValuation() {
		return this.contactValuation;
	}

	public void setContactValuation(String contactValuation) {
		this.contactValuation = contactValuation;
	}

	public List<ActionContact> getActionContacts() {
		return this.actionContacts;
	}

	public void setActionContacts(List<ActionContact> actionContacts) {
		this.actionContacts = actionContacts;
	}

	public ActionContact addActionContact(ActionContact actionContact) {
		getActionContacts().add(actionContact);
		actionContact.setContact(this);

		return actionContact;
	}

	public ActionContact removeActionContact(ActionContact actionContact) {
		getActionContacts().remove(actionContact);
		actionContact.setContact(null);

		return actionContact;
	}

	public List<CampaignContact> getCampaignContacts() {
		return this.campaignContacts;
	}

	public void setCampaignContacts(List<CampaignContact> campaignContacts) {
		this.campaignContacts = campaignContacts;
	}

	public CampaignContact addCampaignContact(CampaignContact campaignContact) {
		getCampaignContacts().add(campaignContact);
		campaignContact.setContact(this);

		return campaignContact;
	}

	public CampaignContact removeCampaignContact(CampaignContact campaignContact) {
		getCampaignContacts().remove(campaignContact);
		campaignContact.setContact(null);

		return campaignContact;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public ContactClassificationType getContactClassificationType() {
		return this.contactClassificationType;
	}

	public void setContactClassificationType(ContactClassificationType contactClassificationType) {
		this.contactClassificationType = contactClassificationType;
	}

	public ContactTitleType getContactTitleType() {
		return this.contactTitleType;
	}

	public void setContactTitleType(ContactTitleType contactTitleType) {
		this.contactTitleType = contactTitleType;
	}

	public List<ContactAddress> getContactAddresses() {
		return this.contactAddresses;
	}

	public void setContactAddresses(List<ContactAddress> contactAddresses) {
		this.contactAddresses = contactAddresses;
	}

	public ContactAddress addContactAddress(ContactAddress contactAddress) {
		getContactAddresses().add(contactAddress);
		contactAddress.setContact(this);

		return contactAddress;
	}

	public ContactAddress removeContactAddress(ContactAddress contactAddress) {
		getContactAddresses().remove(contactAddress);
		contactAddress.setContact(null);

		return contactAddress;
	}

	public List<ContactAttachment> getContactAttachments() {
		return this.contactAttachments;
	}

	public void setContactAttachments(List<ContactAttachment> contactAttachments) {
		this.contactAttachments = contactAttachments;
	}

	public ContactAttachment addContactAttachment(ContactAttachment contactAttachment) {
		getContactAttachments().add(contactAttachment);
		contactAttachment.setContact(this);

		return contactAttachment;
	}

	public ContactAttachment removeContactAttachment(ContactAttachment contactAttachment) {
		getContactAttachments().remove(contactAttachment);
		contactAttachment.setContact(null);

		return contactAttachment;
	}

	public List<ContactTag> getContactTags() {
		return this.contactTags;
	}

	public void setContactTags(List<ContactTag> contactTags) {
		this.contactTags = contactTags;
	}

	public ContactTag addContactTag(ContactTag contactTag) {
		getContactTags().add(contactTag);
		contactTag.setContact(this);

		return contactTag;
	}

	public ContactTag removeContactTag(ContactTag contactTag) {
		getContactTags().remove(contactTag);
		contactTag.setContact(null);

		return contactTag;
	}

	public List<ContactUrl> getContactUrls() {
		return this.contactUrls;
	}

	public void setContactUrls(List<ContactUrl> contactUrls) {
		this.contactUrls = contactUrls;
	}

	public ContactUrl addContactUrl(ContactUrl contactUrl) {
		getContactUrls().add(contactUrl);
		contactUrl.setContact(this);

		return contactUrl;
	}

	public ContactUrl removeContactUrl(ContactUrl contactUrl) {
		getContactUrls().remove(contactUrl);
		contactUrl.setContact(null);

		return contactUrl;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}