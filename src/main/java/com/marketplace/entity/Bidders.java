package com.marketplace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bidders")
public class Bidders {

	@Id
    @GeneratedValue()
    private long id;
	
	@Column(name="bidder_name", length=128, nullable = false)
    private String bidderName;
	
	@Column(name="bidder_company", length=128, nullable = false)
    private String bidderCompany;
	
	@Column(name="bidder_email", length=128, nullable = false)
    private String bidderEmail;
	
	@Column(name="bidder_phone", length=128, nullable = false)
    private String bidderPhone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public String getBidderCompany() {
		return bidderCompany;
	}

	public void setBidderCompany(String bidderCompany) {
		this.bidderCompany = bidderCompany;
	}

	public String getBidderEmail() {
		return bidderEmail;
	}

	public void setBidderEmail(String bidderEmail) {
		this.bidderEmail = bidderEmail;
	}

	public String getBidderPhone() {
		return bidderPhone;
	}

	public void setBidderPhone(String bidderPhone) {
		this.bidderPhone = bidderPhone;
	}
}
