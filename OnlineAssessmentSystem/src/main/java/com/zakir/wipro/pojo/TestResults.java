package com.zakir.wipro.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assessment_Results")
public class TestResults {
	@Id
	@Column(name = "Id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "Test_Date")
	private String testDate;
	
	@Column(name = "Assessment")
	private String assessmentName;
	
	@Column(name = "Test_Marks")
	private int testMarks;
	
	@Column(name = "Email_Id")
	private String emailId;
	
	@Column(name = "Total_Marks")
	private int totalMarks;
	
	@Column(name = "Result")
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
	public int getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(int testMarks) {
		this.testMarks = testMarks;
	}
	public String getEmailId() {
		return emailId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
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
