package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the company_classification_type database table.
 * 
 */
@Entity
@Table(name="company_classification_type")
@NamedQuery(name="CompanyClassificationType.findAll", query="SELECT c FROM CompanyClassificationType c")
public class CompanyClassificationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_classification_type_id")
	private String companyClassificationTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_classification_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date companyClassificationTypeCreateDate;

	@Column(name="company_classification_type_description")
	private String companyClassificationTypeDescription;

	@Column(name="company_classification_type_name")
	private String companyClassificationTypeName;

	public CompanyClassificationType() {
	}

	public String getCompanyClassificationTypeId() {
		return this.companyClassificationTypeId;
	}

	public void setCompanyClassificationTypeId(String companyClassificationTypeId) {
		this.companyClassificationTypeId = companyClassificationTypeId;
	}

	public Date getCompanyClassificationTypeCreateDate() {
		return this.companyClassificationTypeCreateDate;
	}

	public void setCompanyClassificationTypeCreateDate(Date companyClassificationTypeCreateDate) {
		this.companyClassificationTypeCreateDate = companyClassificationTypeCreateDate;
	}

	public String getCompanyClassificationTypeDescription() {
		return this.companyClassificationTypeDescription;
	}

	public void setCompanyClassificationTypeDescription(String companyClassificationTypeDescription) {
		this.companyClassificationTypeDescription = companyClassificationTypeDescription;
	}

	public String getCompanyClassificationTypeName() {
		return this.companyClassificationTypeName;
	}

	public void setCompanyClassificationTypeName(String companyClassificationTypeName) {
		this.companyClassificationTypeName = companyClassificationTypeName;
	}

}