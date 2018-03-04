package com.marketplace.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
    @GeneratedValue()
    private long id;
	
	@Column(name="project_name", length=128, nullable = false)
    private String projectName;
	
	@Column(name="project_description", length=256)
    private String projectDescription;
	
	@Column(name="bid_expiry_date", length=128, nullable = false)
    private Date bidExpiryDate;
	
	@Column(name="project_contact_email", length=128, nullable = false)
    private String projectContactEmail;
	
	@Column(name="project_contact_phone", length=128, nullable = false)
    private String projectContactPhone;
	
	@Column(name="project_bid_status", length=32, nullable = false)
    private String projectBidStatus;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
