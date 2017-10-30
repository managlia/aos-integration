package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the company_address_type database table.
 * 
 */
@Entity
@Table(name="company_address_type")
@NamedQuery(name="CompanyAddressType.findAll", query="SELECT c FROM CompanyAddressType c")
public class CompanyAddressType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_address_type_id")	
	private String companyAddressTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_address_type_create_date", insertable=false, updatable=false)
	@JsonIgnore
	private Date companyAddressTypeCreateDate;

	@Column(name="company_address_type_description")
	private String companyAddressTypeDescription;

	@Column(name="company_address_type_name")
	private String companyAddressTypeName;

	public CompanyAddressType() {
	}

	public String getCompanyAddressTypeId() {
		return this.companyAddressTypeId;
	}

	public void setCompanyAddressTypeId(String companyAddressTypeId) {
		this.companyAddressTypeId = companyAddressTypeId;
	}

	public Date getCompanyAddressTypeCreateDate() {
		return this.companyAddressTypeCreateDate;
	}

	public void setCompanyAddressTypeCreateDate(Date companyAddressTypeCreateDate) {
		this.companyAddressTypeCreateDate = companyAddressTypeCreateDate;
	}

	public String getCompanyAddressTypeDescription() {
		return this.companyAddressTypeDescription;
	}

	public void setCompanyAddressTypeDescription(String companyAddressTypeDescription) {
		this.companyAddressTypeDescription = companyAddressTypeDescription;
	}

	public String getCompanyAddressTypeName() {
		return this.companyAddressTypeName;
	}

	public void setCompanyAddressTypeName(String companyAddressTypeName) {
		this.companyAddressTypeName = companyAddressTypeName;
	}

}