package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the carrier database table.
 * 
 */
@Entity
@NamedQuery(name="Carrier.findAll", query="SELECT c FROM Carrier c")
public class Carrier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="carrier_id")
	private String carrierId;

	@Column(name="carrier_description")
	private String carrierDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="carrier_last_update_date", insertable=false, updatable=false)
	private Date carrierLastUpdateDate;

	@Column(name="carrier_tracking_url")
	private String carrierTrackingUrl;

	@Column(name="carrier_url")
	private String carrierUrl;

	public Carrier() {
	}

	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierDescription() {
		return this.carrierDescription;
	}

	public void setCarrierDescription(String carrierDescription) {
		this.carrierDescription = carrierDescription;
	}

	public Date getCarrierLastUpdateDate() {
		return this.carrierLastUpdateDate;
	}

	public void setCarrierLastUpdateDate(Date carrierLastUpdateDate) {
		this.carrierLastUpdateDate = carrierLastUpdateDate;
	}

	public String getCarrierTrackingUrl() {
		return this.carrierTrackingUrl;
	}

	public void setCarrierTrackingUrl(String carrierTrackingUrl) {
		this.carrierTrackingUrl = carrierTrackingUrl;
	}

	public String getCarrierUrl() {
		return this.carrierUrl;
	}

	public void setCarrierUrl(String carrierUrl) {
		this.carrierUrl = carrierUrl;
	}

}