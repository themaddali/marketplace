package com.marketplace.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_bids")
public class ProjectBids {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="bid_amount", nullable=false)
	private float bidAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bidder_id", nullable = false)
	private Bidders bidders;
	
	@Column(name="bid_date", length=128, nullable = false)
    private Date bidDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}

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

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}
}
