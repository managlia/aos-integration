package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;


/**
 * The persistent class for the email database table.
 * 
 */
@Entity
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id")
	private int actionId;

	@Column(name="email_external_id")
	private String emailExternalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="email_last_retrieved_date")
	private Date emailLastRetrievedDate;

	@Lob
	@Column(name="email_last_retrieved_valiue")
	private String emailLastRetrievedValiue;

	//bi-directional one-to-one association to Action
	@OneToOne
	@JoinColumn(name="action_id")
	private Action action;

	public Email() {
	}

	public int getActionId() {
		return this.actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getEmailExternalId() {
		return this.emailExternalId;
	}

	public void setEmailExternalId(String emailExternalId) {
		this.emailExternalId = emailExternalId;
	}

	public Date getEmailLastRetrievedDate() {
		return this.emailLastRetrievedDate;
	}

	public void setEmailLastRetrievedDate(Date emailLastRetrievedDate) {
		this.emailLastRetrievedDate = emailLastRetrievedDate;
	}

	public String getEmailLastRetrievedValiue() {
		return this.emailLastRetrievedValiue;
	}

	public void setEmailLastRetrievedValiue(String emailLastRetrievedValiue) {
		this.emailLastRetrievedValiue = emailLastRetrievedValiue;
	}
	
	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}


}