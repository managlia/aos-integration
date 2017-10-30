package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the order_product database table.
 * 
 */
@Entity
@Table(name="order_product")
@NamedQuery(name="OrderProduct.findAll", query="SELECT o FROM OrderProduct o")
public class OrderProduct extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_product_id")
	private int orderProductId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_product_update_date")
	private Date orderProductUpdateDate;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	@Column(name="units")
	private BigDecimal units;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="action_id")
	@JsonBackReference
	private PlacedOrder placedOrder;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public OrderProduct() {
	}

	public int getOrderProductId() {
		return this.orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Date getOrderProductUpdateDate() {
		return this.orderProductUpdateDate;
	}

	public void setOrderProductUpdateDate(Date orderProductUpdateDate) {
		this.orderProductUpdateDate = orderProductUpdateDate;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnits() {
		return this.units;
	}

	public void setUnits(BigDecimal units) {
		this.units = units;
	}

	public PlacedOrder getPlacedOrder() {
		return this.placedOrder;
	}

	public void setPlacedOrder(PlacedOrder placedOrder) {
		this.placedOrder = placedOrder;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}