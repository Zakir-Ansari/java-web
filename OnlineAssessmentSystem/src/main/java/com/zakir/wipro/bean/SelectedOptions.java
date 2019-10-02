package com.zakir.wipro.bean;

public class SelectedOptions {
	private String forQuestion1;
	private String forQuestion2;
	private String forQuestion3;
	private String forQuestion4;
	private String forQuestion5;
	
	public String getForQuestion1() {
		return forQuestion1;
	}
	public void setForQuestion1(String forQuestion1) {
		this.forQuestion1 = forQuestion1;
	}
	public String getForQuestion2() {
		return forQuestion2;
	}
	public void setForQuestion2(String forQuestion2) {
		this.forQuestion2 = forQuestion2;
	}
	public String getForQuestion3() {
		return forQuestion3;
	}
	public void setForQuestion3(String forQuestion3) {
		this.forQuestion3 = forQuestion3;
	}
	public String getForQuestion4() {
		return forQuestion4;
	}
	public void setForQuestion4(String forQuestion4) {
		this.forQuestion4 = forQuestion4;
	}
	public String getForQuestion5() {
		return forQuestion5;
	}
	public void setForQuestion5(String forQuestion5) {
		this.forQuestion5 = forQuestion5;
	}
	
	@Override
	public String toString() {
		return "SelectedOptions [forQuestion1=" + forQuestion1 + ", forQuestion2=" + forQuestion2 + ", forQuestion3="
				+ forQuestion3 + ", forQuestion4=" + forQuestion4 + ", forQuestion5=" + forQuestion5 + "]";
	}
}
