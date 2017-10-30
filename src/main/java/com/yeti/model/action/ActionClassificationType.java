package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the action_classification_type database table.
 * 
 */
@Entity
@Table(name="action_classification_type")
@NamedQuery(name="ActionClassificationType.findAll", query="SELECT a FROM ActionClassificationType a")
public class ActionClassificationType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_classification_type_id")
	private String actionClassificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_classification_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date actionClassificationTypeCreateDate;

	@Column(name="action_classification_type_description")
	private String actionClassificationTypeDescription;

	@Column(name="action_classification_type_name")
	private String actionClassificationTypeName;

	public ActionClassificationType() {
	}

	public String getActionClassificationTypeId() {
		return this.actionClassificationTypeId;
	}

	public void setActionClassificationTypeId(String actionClassificationTypeId) {
		this.actionClassificationTypeId = actionClassificationTypeId;
	}

	public Date getActionClassificationTypeCreateDate() {
		return this.actionClassificationTypeCreateDate;
	}

	public void setActionClassificationTypeCreateDate(Date actionClassificationTypeCreateDate) {
		this.actionClassificationTypeCreateDate = actionClassificationTypeCreateDate;
	}

	public String getActionClassificationTypeDescription() {
		return this.actionClassificationTypeDescription;
	}

	public void setActionClassificationTypeDescription(String actionClassificationTypeDescription) {
		this.actionClassificationTypeDescription = actionClassificationTypeDescription;
	}

	public String getActionClassificationTypeName() {
		return this.actionClassificationTypeName;
	}

	public void setActionClassificationTypeName(String actionClassificationTypeName) {
		this.actionClassificationTypeName = actionClassificationTypeName;
	}


}