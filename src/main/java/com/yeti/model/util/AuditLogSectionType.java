package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the audit_log_section_type database table.
 * 
 */
@Entity
@Table(name="audit_log_section_type")
@NamedQuery(name="AuditLogSectionType.findAll", query="SELECT a FROM AuditLogSectionType a")
public class AuditLogSectionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_section_type_id")
	private int auditLogSectionTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_log_section_type_create_date")
	private Date auditLogSectionTypeCreateDate;

	@Column(name="audit_log_section_type_description")
	private String auditLogSectionTypeDescription;

	@Column(name="audit_log_section_type_name")
	private String auditLogSectionTypeName;

	public AuditLogSectionType() {
	}

	public int getAuditLogSectionTypeId() {
		return this.auditLogSectionTypeId;
	}

	public void setAuditLogSectionTypeId(int auditLogSectionTypeId) {
		this.auditLogSectionTypeId = auditLogSectionTypeId;
	}

	public Date getAuditLogSectionTypeCreateDate() {
		return this.auditLogSectionTypeCreateDate;
	}

	public void setAuditLogSectionTypeCreateDate(Date auditLogSectionTypeCreateDate) {
		this.auditLogSectionTypeCreateDate = auditLogSectionTypeCreateDate;
	}

	public String getAuditLogSectionTypeDescription() {
		return this.auditLogSectionTypeDescription;
	}

	public void setAuditLogSectionTypeDescription(String auditLogSectionTypeDescription) {
		this.auditLogSectionTypeDescription = auditLogSectionTypeDescription;
	}

	public String getAuditLogSectionTypeName() {
		return this.auditLogSectionTypeName;
	}

	public void setAuditLogSectionTypeName(String auditLogSectionTypeName) {
		this.auditLogSectionTypeName = auditLogSectionTypeName;
	}

}