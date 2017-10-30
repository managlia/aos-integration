package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_external_id")
	private String productExternalId;

	@Column(name="product_description")
	private String productDescription;

	@Lob
	@Column(name="product_last_retrieved_value", insertable=false, updatable=false)
	private String productLastRetrievedValue;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="product_last_update_date", insertable=false, updatable=false)
	private Date productLastUpdateDate;

	@Column(name="product_name")
	private String productName;

	public Product() {
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductExternalId() {
		return this.productExternalId;
	}

	public void setProductExternalId(String productExternalId) {
		this.productExternalId = productExternalId;
	}

	public String getProductLastRetrievedValue() {
		return this.productLastRetrievedValue;
	}

	public void setProductLastRetrievedValue(String productLastRetrievedValue) {
		this.productLastRetrievedValue = productLastRetrievedValue;
	}

	public Date getProductLastUpdateDate() {
		return this.productLastUpdateDate;
	}

	public void setProductLastUpdateDate(Date productLastUpdateDate) {
		this.productLastUpdateDate = productLastUpdateDate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}