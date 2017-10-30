package com.yeti.model.host;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.action.Action;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.contact.Contact;
import com.yeti.model.report.Report;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_id")
	private int contactId;

	@Column(name="email_system")
	private String emailSystem;

	@Column(name="user_email_login")
	private String userEmailLogin;

	@Column(name="user_email_password")
	private String userEmailPassword;

	@Column(name="user_email_password_key")
	private String userEmailPasswordKey;

	@Column(name="user_external_id")
	private String userExternalId;

	@Column(name="user_login")
	private String userLogin;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_password_key")
	private String userPasswordKey;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="user")
	@JsonManagedReference
	private List<Action> actions;

	//bi-directional many-to-one association to Campaign
	@OneToMany(mappedBy="user")
	@JsonManagedReference
	private List<Campaign> campaigns;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="user")
	@JsonManagedReference
	private List<Report> reports;

	//bi-directional many-to-one association to Contact
	@OneToOne
	@JoinColumn(name="contact_id")
	private Contact contact;
	
	//bi-directional many-to-one association to HostCompany
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference 
	private HostCompany hostCompany;
	
	public User() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getEmailSystem() {
		return this.emailSystem;
	}

	public void setEmailSystem(String emailSystem) {
		this.emailSystem = emailSystem;
	}

	public String getUserEmailLogin() {
		return this.userEmailLogin;
	}

	public void setUserEmailLogin(String userEmailLogin) {
		this.userEmailLogin = userEmailLogin;
	}

	public String getUserEmailPassword() {
		return this.userEmailPassword;
	}

	public void setUserEmailPassword(String userEmailPassword) {
		this.userEmailPassword = userEmailPassword;
	}

	public String getUserEmailPasswordKey() {
		return this.userEmailPasswordKey;
	}

	public void setUserEmailPasswordKey(String userEmailPasswordKey) {
		this.userEmailPasswordKey = userEmailPasswordKey;
	}

	public String getUserExternalId() {
		return this.userExternalId;
	}

	public void setUserExternalId(String userExternalId) {
		this.userExternalId = userExternalId;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPasswordKey() {
		return this.userPasswordKey;
	}

	public void setUserPasswordKey(String userPasswordKey) {
		this.userPasswordKey = userPasswordKey;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Action addAction(Action action) {
		getActions().add(action);
		action.setUser(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setUser(null);

		return action;
	}

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Campaign addCampaign(Campaign campaign) {
		getCampaigns().add(campaign);
		campaign.setUser(this);

		return campaign;
	}

	public Campaign removeCampaign(Campaign campaign) {
		getCampaigns().remove(campaign);
		campaign.setUser(null);

		return campaign;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setUser(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setUser(null);

		return report;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public HostCompany getHostCompany() {
		return this.hostCompany;
	}

	public void setHostCompany(HostCompany hostCompany) {
		this.hostCompany = hostCompany;
	}
	
}