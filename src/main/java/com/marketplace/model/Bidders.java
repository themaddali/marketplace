package com.marketplace.model;

public class Bidders {

    private long id;
    private String bidderName;
    private String bidderCompany;
    private String bidderEmail;
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
