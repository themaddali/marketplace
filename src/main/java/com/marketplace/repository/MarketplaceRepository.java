package com.marketplace.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.entity.Project;

public interface MarketplaceRepository extends JpaRepository<Project, Long>{
	
	Project findById(long id);
	
	List<Project> findByProjectBidStatus(String projectBidStatus);

}
