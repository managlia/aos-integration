package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the audit_log_type database table.
 * 
 */
@Entity
@Table(name="audit_log_type")
@NamedQuery(name="AuditLogType.findAll", query="SELECT a FROM AuditLogType a")
public class AuditLogType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_type_id")
	private int auditLogTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_log_type_create_date")
	private Date auditLogTypeCreateDate;

	@Column(name="audit_log_type_description")
	private String auditLogTypeDescription;

	@Column(name="audit_log_type_name")
	private String auditLogTypeName;

	public AuditLogType() {
	}

	public int getAuditLogTypeId() {
		return this.auditLogTypeId;
	}

	public void setAuditLogTypeId(int auditLogTypeId) {
		this.auditLogTypeId = auditLogTypeId;
	}

	public Date getAuditLogTypeCreateDate() {
		return this.auditLogTypeCreateDate;
	}

	public void setAuditLogTypeCreateDate(Date auditLogTypeCreateDate) {
		this.auditLogTypeCreateDate = auditLogTypeCreateDate;
	}

	public String getAuditLogTypeDescription() {
		return this.auditLogTypeDescription;
	}

	public void setAuditLogTypeDescription(String auditLogTypeDescription) {
		this.auditLogTypeDescription = auditLogTypeDescription;
	}

	public String getAuditLogTypeName() {
		return this.auditLogTypeName;
	}

	public void setAuditLogTypeName(String auditLogTypeName) {
		this.auditLogTypeName = auditLogTypeName;
	}

}