package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the scope_type database table.
 * 
 */
@Entity
@Table(name="scope_type")
@NamedQuery(name="ScopeType.findAll", query="SELECT s FROM ScopeType s")
public class ScopeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="scope_type_id")
	private String scopeTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="scope_type_create_date", insertable=false, updatable=false)
	private Date scopeTypeCreateDate;

	@Column(name="scope_type_description")
	private String scopeTypeDescription;

	@Column(name="scope_type_name")
	private String scopeTypeName;

	public ScopeType() {
	}

	public String getScopeTypeId() {
		return this.scopeTypeId;
	}

	public void setScopeTypeId(String scopeTypeId) {
		this.scopeTypeId = scopeTypeId;
	}

	public Date getScopeTypeCreateDate() {
		return this.scopeTypeCreateDate;
	}

	public void setScopeTypeCreateDate(Date scopeTypeCreateDate) {
		this.scopeTypeCreateDate = scopeTypeCreateDate;
	}

	public String getScopeTypeDescription() {
		return this.scopeTypeDescription;
	}

	public void setScopeTypeDescription(String scopeTypeDescription) {
		this.scopeTypeDescription = scopeTypeDescription;
	}

	public String getScopeTypeName() {
		return this.scopeTypeName;
	}

	public void setScopeTypeName(String scopeTypeName) {
		this.scopeTypeName = scopeTypeName;
	}

}