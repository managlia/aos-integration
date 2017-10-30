package com.yeti.model.company;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.general.Tag;

import java.util.Date;


/**
 * The persistent class for the company_tag database table.
 * 
 */
@Entity
@Table(name="company_tag")
@NamedQuery(name="CompanyTag.findAll", query="SELECT c FROM CompanyTag c")
public class CompanyTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_tag_id")
	private int companyTagId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="company_tag_linkage_date", insertable=false, updatable=false)
	private Date companyTagLinkageDate;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonBackReference
	private Company company;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tag tag;

	public CompanyTag() {
	}

	public int getCompanyTagId() {
		return this.companyTagId;
	}

	public void setCompanyTagId(int companyTagId) {
		this.companyTagId = companyTagId;
	}

	public Date getCompanyTagLinkageDate() {
		return this.companyTagLinkageDate;
	}

	public void setCompanyTagLinkageDate(Date companyTagLinkageDate) {
		this.companyTagLinkageDate = companyTagLinkageDate;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}