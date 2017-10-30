package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;


/**
 * The persistent class for the conversation database table.
 * 
 */
@Entity
@NamedQuery(name="Conversation.findAll", query="SELECT c FROM Conversation c")
public class Conversation extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_id")
	private int actionId;

	@Column(name="conversation_duration")
	private String conversationDuration;

	//bi-directional one-to-one association to Action
	@OneToOne
	@JoinColumn(name="action_id")
	private Action action;

	public Conversation() {
	}

	public int getActionId() {
		return this.actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getConversationDuration() {
		return this.conversationDuration;
	}

	public void setConversationDuration(String conversationDuration) {
		this.conversationDuration = conversationDuration;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
}