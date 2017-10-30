package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.campaign.CampaignAction;
import com.yeti.model.general.ScopeType;
import com.yeti.model.host.User;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id", insertable=false, updatable=false)
	private int actionId;

	@Column(name="action_active")
	private boolean actionActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_actual_completion_date")
	private Date actionActualCompletionDate;

	@Column(name="action_actual_valuation")
	private String actionActualValuation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_create_date")
	private Date actionCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_deactivation_date")
	private Date actionDeactivationDate;

	@Column(name="action_description")
	private String actionDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_last_modified_date")
	private Date actionLastModifiedDate;

	@Column(name="action_name")
	private String actionName;

	@Column(name="action_restrict_to_owner")
	private byte actionRestrictToOwner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_target_completion_date")
	private Date actionTargetCompletionDate;

	@Column(name="action_target_valuation")
	private String actionTargetValuation;

	@Column(name="action_parent_action_id")
	private Integer parentActionId;
	
	@Column(name="action_parent_campaign_id")
	private Integer parentCampaignId;

	//bi-directional many-to-one association to ActionClassificationType
	@ManyToOne
	@JoinColumn(name="action_classification_type_id")
	private ActionClassificationType actionClassificationType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="action_owner_id")
	@JsonBackReference
	private User user;

	//bi-directional many-to-one association to ScopeType
	@ManyToOne
	@JoinColumn(name="scope_type_id")
	private ScopeType scopeType;

	//bi-directional many-to-one association to ActionAction
	@OneToMany
	@JoinColumn(name = "parent_action_id")
	@RestResource(path = "actionChildren", rel="children")
	@JsonIgnore
	private List<ActionAction> actionChildren;

	//bi-directional one-to-one association to Conversation
	@OneToOne(mappedBy="action")
	@JsonIgnore
	private Conversation conversation;

	//bi-directional one-to-one association to Email
	@OneToOne(mappedBy="action")
	@JsonIgnore
	private Email email;

	//bi-directional many-to-one association to OrderProduct
	@OneToOne(mappedBy="action")
	@JsonIgnore
	private PlacedOrder order;

	//bi-directional one-to-one association to Reminder
	@OneToOne(mappedBy="action")
	@JsonIgnore
	private Reminder reminder;

	//bi-directional many-to-one association to ActionAttachment
	@OneToMany(mappedBy="action")
	@JsonManagedReference
	private List<ActionAttachment> actionAttachments;

	//bi-directional many-to-one association to ActionContact
	@OneToMany(mappedBy="action")
	@RestResource(path = "actionContacts", rel="contacts")
	@JsonIgnore
	private List<ActionContact> actionContacts;

	//bi-directional many-to-one association to ActionTag
	@OneToMany(mappedBy="action")
	@JsonManagedReference
	private List<ActionTag> actionTags;

	//bi-directional many-to-one association to CampaignAction
	@OneToMany(mappedBy="action")
	@JsonBackReference 
	private List<CampaignAction> campaignActions;

	public Action() {
	}

	public int getActionId() {
		return this.actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public boolean getActionActive() {
		return this.actionActive;
	}

	public void setActionActive(boolean actionActive) {
		this.actionActive = actionActive;
	}

	public Date getActionActualCompletionDate() {
		return this.actionActualCompletionDate;
	}

	public void setActionActualCompletionDate(Date actionActualCompletionDate) {
		this.actionActualCompletionDate = actionActualCompletionDate;
	}

	public String getActionActualValuation() {
		return this.actionActualValuation;
	}

	public void setActionActualValuation(String actionActualValuation) {
		this.actionActualValuation = actionActualValuation;
	}

	public Date getActionCreateDate() {
		return this.actionCreateDate;
	}

	public void setActionCreateDate(Date actionCreateDate) {
		this.actionCreateDate = actionCreateDate;
	}

	public Date getActionDeactivationDate() {
		return this.actionDeactivationDate;
	}

	public void setActionDeactivationDate(Date actionDeactivationDate) {
		this.actionDeactivationDate = actionDeactivationDate;
	}

	public String getActionDescription() {
		return this.actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public Date getActionLastModifiedDate() {
		return this.actionLastModifiedDate;
	}

	public void setActionLastModifiedDate(Date actionLastModifiedDate) {
		this.actionLastModifiedDate = actionLastModifiedDate;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public byte getActionRestrictToOwner() {
		return this.actionRestrictToOwner;
	}

	public void setActionRestrictToOwner(byte actionRestrictToOwner) {
		this.actionRestrictToOwner = actionRestrictToOwner;
	}

	public Date getActionTargetCompletionDate() {
		return this.actionTargetCompletionDate;
	}

	public void setActionTargetCompletionDate(Date actionTargetCompletionDate) {
		this.actionTargetCompletionDate = actionTargetCompletionDate;
	}

	public String getActionTargetValuation() {
		return this.actionTargetValuation;
	}

	public void setActionTargetValuation(String actionTargetValuation) {
		this.actionTargetValuation = actionTargetValuation;
	}

	public Integer getParentActionId() {
		return this.parentActionId;
	}

	public void setParentActionId(Integer parentActionId) {
		this.parentActionId = parentActionId;
	}

	public Integer getParentCampaignId() {
		return this.parentCampaignId;
	}

	public void setParentCampaignId(Integer parentCampaignId) {
		this.parentCampaignId = parentCampaignId;
	}
	
	public ActionClassificationType getActionClassificationType() {
		return this.actionClassificationType;
	}

	public void setActionClassificationType(ActionClassificationType actionClassificationType) {
		this.actionClassificationType = actionClassificationType;
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

	public List<ActionAction> getActionChildren() {
		return this.actionChildren;
	}

	public void setActionChildren(List<ActionAction> actionChildren) {
		this.actionChildren = actionChildren;
	}

	public List<ActionAttachment> getActionAttachments() {
		return this.actionAttachments;
	}

	public void setActionAttachments(List<ActionAttachment> actionAttachments) {
		this.actionAttachments = actionAttachments;
	}

	public ActionAttachment addActionAttachment(ActionAttachment actionAttachment) {
		getActionAttachments().add(actionAttachment);
		actionAttachment.setAction(this);

		return actionAttachment;
	}

	public ActionAttachment removeActionAttachment(ActionAttachment actionAttachment) {
		getActionAttachments().remove(actionAttachment);
		actionAttachment.setAction(null);

		return actionAttachment;
	}

	public List<ActionContact> getActionContacts() {
		return this.actionContacts;
	}

	public void setActionContacts(List<ActionContact> actionContacts) {
		this.actionContacts = actionContacts;
	}

	public ActionContact addActionContact(ActionContact actionContact) {
		getActionContacts().add(actionContact);
		actionContact.setAction(this);

		return actionContact;
	}

	public ActionContact removeActionContact(ActionContact actionContact) {
		getActionContacts().remove(actionContact);
		actionContact.setAction(null);

		return actionContact;
	}

	public List<ActionTag> getActionTags() {
		return this.actionTags;
	}

	public void setActionTags(List<ActionTag> actionTags) {
		this.actionTags = actionTags;
	}

	public ActionTag addActionTag(ActionTag actionTag) {
		getActionTags().add(actionTag);
		actionTag.setAction(this);

		return actionTag;
	}

	public ActionTag removeActionTag(ActionTag actionTag) {
		getActionTags().remove(actionTag);
		actionTag.setAction(null);

		return actionTag;
	}

	public List<CampaignAction> getCampaignActions() {
		return this.campaignActions;
	}

	public void setCampaignActions(List<CampaignAction> campaignActions) {
		this.campaignActions = campaignActions;
	}

	public CampaignAction addCampaignAction(CampaignAction campaignAction) {
		getCampaignActions().add(campaignAction);
		campaignAction.setAction(this);

		return campaignAction;
	}

	public CampaignAction removeCampaignAction(CampaignAction campaignAction) {
		getCampaignActions().remove(campaignAction);
		campaignAction.setAction(null);

		return campaignAction;
	}
	
	public Conversation getConversation() {
		return this.conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public Email getEmail() {
		return this.email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public PlacedOrder getOrder() {
		return this.order;
	}

	public void setOrder(PlacedOrder order) {
		this.order = order;
	}
		
	public Reminder getReminder() {
		return this.reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
		

}