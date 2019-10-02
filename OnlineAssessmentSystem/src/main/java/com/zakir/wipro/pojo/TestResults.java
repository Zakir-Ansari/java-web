package com.zakir.wipro.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Hibernate Assessment")
public class TestResults {
	
	@Column(name = "Test Date", nullable = false)
	private String testDate;
	
	@Column(name = "Assessment", nullable = false)
	private String assessmentName;
	
	@Column(name = "Test Marks", nullable = false)
	private String testMarks;
	
	@Column(name = "Email Id", nullable = false)
	private String emailId;
	
	@Column(name = "Total Marks", nullable = false)
	private String totalMarks;
	
	@Column(name = "Result", nullable = false)
	private String result;
	
	
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public String getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(String testMarks) {
		this.testMarks = testMarks;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "TestResults [testDate=" + testDate + ", assessmentName=" + assessmentName + ", testMarks=" + testMarks
				+ ", emailId=" + emailId + ", totalMarks=" + totalMarks + ", result=" + result + "]";
	}
	
	
}
