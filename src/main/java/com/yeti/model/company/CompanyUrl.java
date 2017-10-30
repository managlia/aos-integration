package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;


/**
 * The persistent class for the company_url database table.
 * 
 */
@Entity
@Table(name="company_url")
@NamedQuery(name="CompanyUrl.findAll", query="SELECT c FROM CompanyUrl c")
public class CompanyUrl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_url_id")
	private int companyUrlId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_url_create_date", insertable=true, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date companyUrlCreateDate;

	@Column(name="company_url_description")
	private String companyUrlDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_url_last_modified_date", insertable=false, updatable=false)
	private Date companyUrlLastModifiedDate;

	@Column(name="company_url_value")
	private String companyUrlValue;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference
	private Company company;

	//bi-directional many-to-one association to CompanyUrlType
	@ManyToOne
	@JoinColumn(name="company_url_type_id")
	private CompanyUrlType companyUrlType;

	public CompanyUrl() {
	}

	public int getCompanyUrlId() {
		return this.companyUrlId;
	}

	public void setCompanyUrlId(int companyUrlId) {
		this.companyUrlId = companyUrlId;
	}

	public Date getCompanyUrlCreateDate() {
		return this.companyUrlCreateDate;
	}

	public void setCompanyUrlCreateDate(Date companyUrlCreateDate) {
		this.companyUrlCreateDate = companyUrlCreateDate;
	}

	public String getCompanyUrlDescription() {
		return this.companyUrlDescription;
	}

	public void setCompanyUrlDescription(String companyUrlDescription) {
		this.companyUrlDescription = companyUrlDescription;
	}

	public Date getCompanyUrlLastModifiedDate() {
		return this.companyUrlLastModifiedDate;
	}

	public void setCompanyUrlLastModifiedDate(Date companyUrlLastModifiedDate) {
		this.companyUrlLastModifiedDate = companyUrlLastModifiedDate;
	}

	public String getCompanyUrlValue() {
		return this.companyUrlValue;
	}

	public void setCompanyUrlValue(String companyUrlValue) {
		this.companyUrlValue = companyUrlValue;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyUrlType getCompanyUrlType() {
		return this.companyUrlType;
	}

	public void setCompanyUrlType(CompanyUrlType companyUrlType) {
		this.companyUrlType = companyUrlType;
	}

}