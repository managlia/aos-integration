package com.yeti.model.report;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeti.model.host.User;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="report_id")
	private int reportId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="report_create_date")
	private Date reportCreateDate;

	@Column(name="report_description")
	private String reportDescription;

	@Column(name="report_generate_automatically")
	private byte reportGenerateAutomatically;

	@Column(name="report_generate_on")
	private byte reportGenerateOn;

	@Column(name="report_generation_frequency")
	private String reportGenerationFrequency;

	@Column(name="report_name")
	private String reportName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="report_creator_id")
	@JsonBackReference
	private User user;

	//bi-directional many-to-one association to ReportDefinitionElement
	@OneToMany(mappedBy="report")
	private List<ReportDefinitionElement> reportDefinitionElements;

	//bi-directional many-to-one association to ReportRepository
	@OneToMany(mappedBy="report")
	private List<ReportRepository> reportRepositories;

	public Report() {
	}

	public int getReportId() {
		return this.reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Date getReportCreateDate() {
		return this.reportCreateDate;
	}

	public void setReportCreateDate(Date reportCreateDate) {
		this.reportCreateDate = reportCreateDate;
	}

	public String getReportDescription() {
		return this.reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public byte getReportGenerateAutomatically() {
		return this.reportGenerateAutomatically;
	}

	public void setReportGenerateAutomatically(byte reportGenerateAutomatically) {
		this.reportGenerateAutomatically = reportGenerateAutomatically;
	}

	public byte getReportGenerateOn() {
		return this.reportGenerateOn;
	}

	public void setReportGenerateOn(byte reportGenerateOn) {
		this.reportGenerateOn = reportGenerateOn;
	}

	public String getReportGenerationFrequency() {
		return this.reportGenerationFrequency;
	}

	public void setReportGenerationFrequency(String reportGenerationFrequency) {
		this.reportGenerationFrequency = reportGenerationFrequency;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ReportDefinitionElement> getReportDefinitionElements() {
		return this.reportDefinitionElements;
	}

	public void setReportDefinitionElements(List<ReportDefinitionElement> reportDefinitionElements) {
		this.reportDefinitionElements = reportDefinitionElements;
	}

	public ReportDefinitionElement addReportDefinitionElement(ReportDefinitionElement reportDefinitionElement) {
		getReportDefinitionElements().add(reportDefinitionElement);
		reportDefinitionElement.setReport(this);

		return reportDefinitionElement;
	}

	public ReportDefinitionElement removeReportDefinitionElement(ReportDefinitionElement reportDefinitionElement) {
		getReportDefinitionElements().remove(reportDefinitionElement);
		reportDefinitionElement.setReport(null);

		return reportDefinitionElement;
	}

	public List<ReportRepository> getReportRepositories() {
		return this.reportRepositories;
	}

	public void setReportRepositories(List<ReportRepository> reportRepositories) {
		this.reportRepositories = reportRepositories;
	}

	public ReportRepository addReportRepository(ReportRepository reportRepository) {
		getReportRepositories().add(reportRepository);
		reportRepository.setReport(this);

		return reportRepository;
	}

	public ReportRepository removeReportRepository(ReportRepository reportRepository) {
		getReportRepositories().remove(reportRepository);
		reportRepository.setReport(null);

		return reportRepository;
	}

}