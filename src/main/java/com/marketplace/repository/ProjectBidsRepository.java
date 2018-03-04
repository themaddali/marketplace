package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marketplace.entity.ProjectBids;

public interface ProjectBidsRepository extends JpaRepository<ProjectBids, Long> {
	
	@Query("Select projBid from ProjectBids projBid where projBid.project.id = :id and projBid.bidAmount = (select min(projbid.bidAmount) from ProjectBids projbid) ")
	ProjectBids find(@Param("id") long id);
	
	ProjectBids findTopByOrderByBidAmountAsc();

}
