package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Tag;

import java.util.Date;


/**
 * The persistent class for the action_tag database table.
 * 
 */
@Entity
@Table(name="action_tag")
@NamedQuery(name="ActionTag.findAll", query="SELECT a FROM ActionTag a")
public class ActionTag extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_tag_id")
	private int actionTagId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_tag_linkage_date")
	private Date actionTagLinkageDate;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="action_id")
	@JsonBackReference
	private Action action;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tag tag;

	public ActionTag() {
	}

	public int getActionTagId() {
		return this.actionTagId;
	}

	public void setActionTagId(int actionTagId) {
		this.actionTagId = actionTagId;
	}

	public Date getActionTagLinkageDate() {
		return this.actionTagLinkageDate;
	}

	public void setActionTagLinkageDate(Date actionTagLinkageDate) {
		this.actionTagLinkageDate = actionTagLinkageDate;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}