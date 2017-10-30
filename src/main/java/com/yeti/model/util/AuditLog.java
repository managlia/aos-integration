package com.yeti.model.util;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the audit_log database table.
 * 
 */
@Entity
@Table(name="audit_log")
@NamedQuery(name="AuditLog.findAll", query="SELECT a FROM AuditLog a")
public class AuditLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="audit_log_id")
	private int auditLogId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_log_date")
	private Date auditLogDate;

	@Column(name="entity_id")
	private int entityId;

	@Column(name="entity_name")
	private String entityName;

	@Column(name="tranaction_log_actor_id")
	private int tranactionLogActorId;

	//bi-directional many-to-one association to AuditLogSectionType
	@ManyToOne
	@JoinColumn(name="audit_log_section_type_id")
	private AuditLogSectionType auditLogSectionType;

	//bi-directional many-to-one association to AuditLogType
	@ManyToOne
	@JoinColumn(name="audit_log_type_id")
	private AuditLogType auditLogType;

	//bi-directional one-to-one association to AuditLogDetail
	@OneToOne(mappedBy="auditLog")
	@JsonIgnore
	private AuditLogDetail auditLogDetail;

	public AuditLog() {
	}

	public int getAuditLogId() {
		return this.auditLogId;
	}

	public void setAuditLogId(int auditLogId) {
		this.auditLogId = auditLogId;
	}

	public Date getAuditLogDate() {
		return this.auditLogDate;
	}

	public void setAuditLogDate(Date auditLogDate) {
		this.auditLogDate = auditLogDate;
	}

	public int getEntityId() {
		return this.entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return this.entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public int getTranactionLogActorId() {
		return this.tranactionLogActorId;
	}

	public void setTranactionLogActorId(int tranactionLogActorId) {
		this.tranactionLogActorId = tranactionLogActorId;
	}

	public AuditLogSectionType getAuditLogSectionType() {
		return this.auditLogSectionType;
	}

	public void setAuditLogSectionType(AuditLogSectionType auditLogSectionType) {
		this.auditLogSectionType = auditLogSectionType;
	}

	public AuditLogType getAuditLogType() {
		return this.auditLogType;
	}

	public void setAuditLogType(AuditLogType auditLogType) {
		this.auditLogType = auditLogType;
	}

	public AuditLogDetail getAuditLogDetail() {
		return this.auditLogDetail;
	}

	public void setAuditLogDetail(AuditLogDetail auditLogDetail) {
		this.auditLogDetail = auditLogDetail;
	}

}