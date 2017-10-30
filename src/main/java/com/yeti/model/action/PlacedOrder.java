package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.general.Carrier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name="placed_order")
@NamedQuery(name="PlacedOrder.findAll", query="SELECT a FROM PlacedOrder a")
public class PlacedOrder extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id")
	private int actionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_bill_date")
	private Date orderBillDate;

	@Column(name="order_carrier_tracking_number")
	private String orderCarrierTrackingNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_create_date")
	private Date orderCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_delivery_date")
	private Date orderDeliveryDate;

	@Column(name="order_external_id")
	private String orderExternalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_last_retrieved_date")
	private Date orderLastRetrievedDate;

	@Lob
	@Column(name="order_last_retrieved_value")
	private String orderLastRetrievedValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_pay_date")
	private Date orderPayDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_ship_date")
	private Date orderShipDate;

	@Column(name="order_valuation")
	private BigDecimal orderValuation;

	@Column(name="order_valuation_currency")
	private String orderValuationCurrency;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="placedOrder")
	@JsonManagedReference
	private List<OrderProduct> orderProducts;

	//bi-directional many-to-one association to Carrier
	@ManyToOne
	@JoinColumn(name="carrier_id")
	private Carrier carrier;

	//bi-directional many-to-one association to OrderStateType
	@ManyToOne
	@JoinColumn(name="order_state_type_id")
	private OrderStateType orderStateType;
	
	//bi-directional one-to-one association to Action
	@OneToOne
	@JoinColumn(name="action_id")
	private Action action;

	public PlacedOrder() {
	}

	public int getActionId() {
		return this.actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public Date getOrderBillDate() {
		return this.orderBillDate;
	}

	public void setOrderBillDate(Date orderBillDate) {
		this.orderBillDate = orderBillDate;
	}

	public String getOrderCarrierTrackingNumber() {
		return this.orderCarrierTrackingNumber;
	}

	public void setOrderCarrierTrackingNumber(String orderCarrierTrackingNumber) {
		this.orderCarrierTrackingNumber = orderCarrierTrackingNumber;
	}

	public Date getOrderCreateDate() {
		return this.orderCreateDate;
	}

	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}

	public Date getOrderDeliveryDate() {
		return this.orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	public String getOrderExternalId() {
		return this.orderExternalId;
	}

	public void setOrderExternalId(String orderExternalId) {
		this.orderExternalId = orderExternalId;
	}

	public Date getOrderLastRetrievedDate() {
		return this.orderLastRetrievedDate;
	}

	public void setOrderLastRetrievedDate(Date orderLastRetrievedDate) {
		this.orderLastRetrievedDate = orderLastRetrievedDate;
	}

	public String getOrderLastRetrievedValue() {
		return this.orderLastRetrievedValue;
	}

	public void setOrderLastRetrievedValue(String orderLastRetrievedValue) {
		this.orderLastRetrievedValue = orderLastRetrievedValue;
	}

	public Date getOrderPayDate() {
		return this.orderPayDate;
	}

	public void setOrderPayDate(Date orderPayDate) {
		this.orderPayDate = orderPayDate;
	}

	public Date getOrderShipDate() {
		return this.orderShipDate;
	}

	public void setOrderShipDate(Date orderShipDate) {
		this.orderShipDate = orderShipDate;
	}

	public BigDecimal getOrderValuation() {
		return this.orderValuation;
	}

	public void setOrderValuation(BigDecimal orderValuation) {
		this.orderValuation = orderValuation;
	}

	public String getOrderValuationCurrency() {
		return this.orderValuationCurrency;
	}

	public void setOrderValuationCurrency(String orderValuationCurrency) {
		this.orderValuationCurrency = orderValuationCurrency;
	}

	public List<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().add(orderProduct);
		orderProduct.setPlacedOrder(this);

		return orderProduct;
	}

	public OrderProduct removeOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().remove(orderProduct);
		orderProduct.setPlacedOrder(null);

		return orderProduct;
	}

	public Carrier getCarrier() {
		return this.carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public OrderStateType getOrderStateType() {
		return this.orderStateType;
	}

	public void setOrderStateType(OrderStateType orderStateType) {
		this.orderStateType = orderStateType;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}