package com.yeti.model.general;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
//@Audited
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tag_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tagId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="tag_create_date", insertable=false, updatable=false)
	private Date tagCreateDate;

	@Column(name="tag_creator_id")
	private int tagCreatorId;

	@Column(name="tag_description")
	private String tagDescription;

	@Column(name="tag_name")
	private String tagName;

	public Tag() {
	}

	public int getTagId() {
		return this.tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public Date getTagCreateDate() {
		return this.tagCreateDate;
	}

	public void setTagCreateDate(Date tagCreateDate) {
		this.tagCreateDate = tagCreateDate;
	}

	public int getTagCreatorId() {
		return this.tagCreatorId;
	}

	public void setTagCreatorId(int tagCreatorId) {
		this.tagCreatorId = tagCreatorId;
	}

	public String getTagDescription() {
		return this.tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}