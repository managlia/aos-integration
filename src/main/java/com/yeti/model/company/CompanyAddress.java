package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;


/**
 * The persistent class for the company_address database table.
 * 
 */
@Entity
@Table(name="company_address")
@NamedQuery(name="CompanyAddress.findAll", query="SELECT c FROM CompanyAddress c")
public class CompanyAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_address_id")
	private int companyAddressId;

	@Column(name="company_address_1")
	private String companyAddress1;

	@Column(name="company_address_2")
	private String companyAddress2;

	@Column(name="company_city")
	private String companyCity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_city_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date companyCityCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_city_last_modified_date", insertable=false, updatable=false)
	private Date companyCityLastModifiedDate;

	@Column(name="company_country")
	private String companyCountry;

	@Column(name="company_postal_code")
	private String companyPostalCode;

	@Column(name="company_state")
	private String companyState;

	//bi-directional many-to-one association to CompanyAddressType
	@ManyToOne
	@JoinColumn(name="company_address_type_id")
	private CompanyAddressType companyAddressType;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference
	private Company company;

	public CompanyAddress() {
	}

	public int getCompanyAddressId() {
		return this.companyAddressId;
	}

	public void setCompanyAddressId(int companyAddressId) {
		this.companyAddressId = companyAddressId;
	}

	public String getCompanyAddress1() {
		return this.companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getCompanyAddress2() {
		return this.companyAddress2;
	}

	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	public String getCompanyCity() {
		return this.companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public Date getCompanyCityCreateDate() {
		return this.companyCityCreateDate;
	}

	public void setCompanyCityCreateDate(Date companyCityCreateDate) {
		this.companyCityCreateDate = companyCityCreateDate;
	}

	public Date getCompanyCityLastModifiedDate() {
		return this.companyCityLastModifiedDate;
	}

	public void setCompanyCityLastModifiedDate(Date companyCityLastModifiedDate) {
		this.companyCityLastModifiedDate = companyCityLastModifiedDate;
	}

	public String getCompanyCountry() {
		return this.companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public String getCompanyPostalCode() {
		return this.companyPostalCode;
	}

	public void setCompanyPostalCode(String companyPostalCode) {
		this.companyPostalCode = companyPostalCode;
	}

	public String getCompanyState() {
		return this.companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public CompanyAddressType getCompanyAddressType() {
		return this.companyAddressType;
	}

	public void setCompanyAddressType(CompanyAddressType companyAddressType) {
		this.companyAddressType = companyAddressType;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}