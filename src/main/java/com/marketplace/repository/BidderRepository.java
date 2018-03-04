package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.entity.Bidders;

public interface BidderRepository extends JpaRepository<Bidders, Long>{
	
	Bidders findByBidderCompany(String bidderCompany);

}
