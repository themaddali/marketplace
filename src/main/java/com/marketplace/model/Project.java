package com.marketplace.model;

import java.util.Date;

public class Project {
	
	private String projectId;
	private String projectName;
	private String projectDescription;
	private Date bidExpiryDate;
	private String projectContactEmail;
	private String projectContactPhone;
	private String projectBidStatus;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	public Date getBidExpiryDate() {
		return bidExpiryDate;
	}
	public void setBidExpiryDate(Date bidExpiryDate) {
		this.bidExpiryDate = bidExpiryDate;
	}
	public String getProjectContactEmail() {
		return projectContactEmail;
	}
	public void setProjectContactEmail(String projectContactEmail) {
		this.projectContactEmail = projectContactEmail;
	}
	public String getProjectContactPhone() {
		return projectContactPhone;
	}
	public void setProjectContactPhone(String projectContactPhone) {
		this.projectContactPhone = projectContactPhone;
	}
	public String getProjectBidStatus() {
		return projectBidStatus;
	}
	public void setProjectBidStatus(String projectBidStatus) {
		this.projectBidStatus = projectBidStatus;
	}
	

}
