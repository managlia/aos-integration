package com.yeti.model.report;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report_definition_element database table.
 * 
 */
@Entity
@Table(name="report_definition_element")
@NamedQuery(name="ReportDefinitionElement.findAll", query="SELECT r FROM ReportDefinitionElement r")
public class ReportDefinitionElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="report_definition_id")
	private int reportDefinitionId;

	@Lob
	@Column(name="report_definition_element")
	private String reportDefinitionElement;

	//bi-directional many-to-one association to Report
	@ManyToOne
	@JoinColumn(name="report_id")
	private Report report;

	public ReportDefinitionElement() {
	}

	public int getReportDefinitionId() {
		return this.reportDefinitionId;
	}

	public void setReportDefinitionId(int reportDefinitionId) {
		this.reportDefinitionId = reportDefinitionId;
	}

	public String getReportDefinitionElement() {
		return this.reportDefinitionElement;
	}

	public void setReportDefinitionElement(String reportDefinitionElement) {
		this.reportDefinitionElement = reportDefinitionElement;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}