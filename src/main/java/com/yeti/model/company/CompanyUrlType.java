package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the company_url_type database table.
 * 
 */
@Entity
@Table(name="company_url_type")
@NamedQuery(name="CompanyUrlType.findAll", query="SELECT c FROM CompanyUrlType c")
public class CompanyUrlType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_url_type_id")
	private String companyUrlTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="company_url_type_create_date", insertable=false, updatable=false)
	private Date companyUrlTypeCreateDate;

	@Column(name="company_url_type_description")
	private String companyUrlTypeDescription;

	@Column(name="company_url_type_name")
	private String companyUrlTypeName;

	public CompanyUrlType() {
	}

	public String getCompanyUrlTypeId() {
		return this.companyUrlTypeId;
	}

	public void setCompanyUrlTypeId(String companyUrlTypeId) {
		this.companyUrlTypeId = companyUrlTypeId;
	}

	public Date getCompanyUrlTypeCreateDate() {
		return this.companyUrlTypeCreateDate;
	}

	public void setCompanyUrlTypeCreateDate(Date companyUrlTypeCreateDate) {
		this.companyUrlTypeCreateDate = companyUrlTypeCreateDate;
	}

	public String getCompanyUrlTypeDescription() {
		return this.companyUrlTypeDescription;
	}

	public void setCompanyUrlTypeDescription(String companyUrlTypeDescription) {
		this.companyUrlTypeDescription = companyUrlTypeDescription;
	}

	public String getCompanyUrlTypeName() {
		return this.companyUrlTypeName;
	}

	public void setCompanyUrlTypeName(String companyUrlTypeName) {
		this.companyUrlTypeName = companyUrlTypeName;
	}

}