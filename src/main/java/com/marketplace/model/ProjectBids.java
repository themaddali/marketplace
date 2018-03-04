package com.marketplace.model;

import java.util.Date;

import com.marketplace.model.Bidders;
import com.marketplace.model.Project;

public class ProjectBids {
	
	private Project project;
	private Bidders bidders;
	private float bidAmount;
	private Date bidDate;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Bidders getBidders() {
		return bidders;
	}
	public void setBidders(Bidders bidders) {
		this.bidders = bidders;
	}
	public float getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Date getBidDate() {
		return bidDate;
	}
	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

}
