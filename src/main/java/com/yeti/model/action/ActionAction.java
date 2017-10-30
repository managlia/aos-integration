package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;


/**
 * The persistent class for the action_action database table.
 * 
 */
@Entity
@Table(name="action_action")
@NamedQuery(name="ActionAction.findAll", query="SELECT a FROM ActionAction a")
public class ActionAction extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_action_id")
	private int actionActionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_action_linkage_date")
	private Date actionActionLinkageDate;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="child_action_id")
	@JsonManagedReference
	private Action childAction;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="parent_action_id")
	@JsonBackReference
	private Action parentAction;

	public ActionAction() {
	}

	public int getActionActionId() {
		return this.actionActionId;
	}

	public void setActionActionId(int actionActionId) {
		this.actionActionId = actionActionId;
	}

	public Date getActionActionLinkageDate() {
		return this.actionActionLinkageDate;
	}

	public void setActionActionLinkageDate(Date actionActionLinkageDate) {
		this.actionActionLinkageDate = actionActionLinkageDate;
	}

	public Action getChildAction() {
		return this.childAction;
	}

	public void setChildAction(Action childAction) {
		this.childAction = childAction;
	}

	public Action getParentAction() {
		return this.parentAction;
	}

	public void setParentAction(Action parentAction) {
		this.parentAction = parentAction;
	}

}