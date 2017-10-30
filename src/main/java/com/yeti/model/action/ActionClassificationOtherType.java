package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the action_classification_other_type database table.
 * 
 */
@Entity
@Table(name="action_classification_other_type")
@NamedQuery(name="ActionClassificationOtherType.findAll", query="SELECT c FROM ActionClassificationOtherType c")
public class ActionClassificationOtherType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_classification_other_type_id", insertable=false, updatable=false)
	private int actionClassificationOtherTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_classification_other_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date actionClassificationOtherTypeCreateDate;

	@Column(name="action_classification_other_type_description")
	private String actionClassificationOtherTypeDescription;

	@Column(name="action_classification_other_type_name")
	private String actionClassificationOtherTypeName;

	public ActionClassificationOtherType() {
	}

	public int getActionClassificationOtherTypeId() {
		return this.actionClassificationOtherTypeId;
	}

	public void setActionClassificationOtherTypeId(int actionClassificationOtherTypeId) {
		this.actionClassificationOtherTypeId = actionClassificationOtherTypeId;
	}

	public Date getActionClassificationOtherTypeCreateDate() {
		return this.actionClassificationOtherTypeCreateDate;
	}

	public void setActionClassificationOtherTypeCreateDate(Date actionClassificationOtherTypeCreateDate) {
		this.actionClassificationOtherTypeCreateDate = actionClassificationOtherTypeCreateDate;
	}

	public String getActionClassificationOtherTypeDescription() {
		return this.actionClassificationOtherTypeDescription;
	}

	public void setActionClassificationOtherTypeDescription(String actionClassificationOtherTypeDescription) {
		this.actionClassificationOtherTypeDescription = actionClassificationOtherTypeDescription;
	}

	public String getActionClassificationOtherTypeName() {
		return this.actionClassificationOtherTypeName;
	}

	public void setActionClassificationOtherTypeName(String actionClassificationOtherTypeName) {
		this.actionClassificationOtherTypeName = actionClassificationOtherTypeName;
	}

}