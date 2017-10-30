package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the order_state_type database table.
 * 
 */
@Entity
@Table(name="order_state_type")
@NamedQuery(name="OrderStateType.findAll", query="SELECT o FROM OrderStateType o")
public class OrderStateType extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_state_type_id")
	private String orderStateTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="order_state_type_create_date", insertable=false, updatable=false)
	private Date orderStateTypeCreateDate;

	@Column(name="order_state_type_description")
	private String orderStateTypeDescription;

	@Column(name="order_state_type_name")
	private String orderStateTypeName;

	public OrderStateType() {
	}

	public String getOrderStateTypeId() {
		return this.orderStateTypeId;
	}

	public void setOrderStateTypeId(String orderStateTypeId) {
		this.orderStateTypeId = orderStateTypeId;
	}

	public Date getOrderStateTypeCreateDate() {
		return this.orderStateTypeCreateDate;
	}

	public void setOrderStateTypeCreateDate(Date orderStateTypeCreateDate) {
		this.orderStateTypeCreateDate = orderStateTypeCreateDate;
	}

	public String getOrderStateTypeDescription() {
		return this.orderStateTypeDescription;
	}

	public void setOrderStateTypeDescription(String orderStateTypeDescription) {
		this.orderStateTypeDescription = orderStateTypeDescription;
	}

	public String getOrderStateTypeName() {
		return this.orderStateTypeName;
	}

	public void setOrderStateTypeName(String orderStateTypeName) {
		this.orderStateTypeName = orderStateTypeName;
	}

}