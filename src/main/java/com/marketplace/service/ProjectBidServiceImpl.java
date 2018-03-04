package com.marketplace.service;

import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Bidders;
import com.marketplace.entity.Project;
import com.marketplace.entity.ProjectBids;
import com.marketplace.repository.BidderRepository;
import com.marketplace.repository.MarketplaceRepository;
import com.marketplace.repository.ProjectBidsRepository;

@Service("projectBidService")
public class ProjectBidServiceImpl implements ProjectBidService {
	
	@Autowired
	private MarketplaceRepository marketplaceRepo;
	
	@Autowired
	private BidderRepository bidderRepo;
	
	@Autowired
	private ProjectBidsRepository projectBidsRepo;
	

	@Override
	public Project createProject(Project project) {
		Project savedObj = marketplaceRepo.save(project);
		return savedObj;
	}

	@Override
	public Project getProjectById(String projectId) {
		return marketplaceRepo.findById(Long.parseLong(projectId));
	}
	
	
	

	@Override
	public ProjectBids bidForProject(com.marketplace.model.ProjectBids projBids) {
		ProjectBids projBidsEntity = new ProjectBids();
		
		Project projEntity = marketplaceRepo.findById(Long.parseLong(projBids.getProject().getProjectId()));
		if(projEntity.getProjectBidStatus().equalsIgnoreCase("Open"))
			projBidsEntity.setProject(projEntity);
		else
			return projBidsEntity;
		
		Bidders bidder = bidderRepo.findByBidderCompany(projBids.getBidders().getBidderCompany());
		if(bidder != null)
			projBidsEntity.setBidders(bidder);
		else{
			Bidders saveObj = null;
			try {
				saveObj = bidderRepo.save(convertToEntity(projBids.getBidders()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			projBidsEntity.setBidders(saveObj);
		}
		
		projBidsEntity.setBidAmount(projBids.getBidAmount());
		projBidsEntity.setBidDate(projBids.getBidDate());
		
		ProjectBids saveObj = projectBidsRepo.save(projBidsEntity);
		
		return saveObj;

	}
	
	private com.marketplace.entity.Bidders convertToEntity(com.marketplace.model.Bidders bidderDto) throws ParseException{
		ModelMapper modelMapper = new ModelMapper();
		com.marketplace.entity.Bidders bidderEntity = modelMapper.map(bidderDto, com.marketplace.entity.Bidders.class);
		return bidderEntity;
	}
	
	private com.marketplace.model.Bidders convertToDto(com.marketplace.entity.Bidders bidderEntity){
		ModelMapper modelMapper = new ModelMapper();
		com.marketplace.model.Bidders bidderDto = modelMapper.map(bidderEntity, com.marketplace.model.Bidders.class);
		return bidderDto;
	}

	@Override
	public List<Project> getOpenProjects() {
		return marketplaceRepo.findByProjectBidStatus("Open");
	}

	@Override
	public ProjectBids getLowestBidProject(String projectId) {
		return projectBidsRepo.find(Long.parseLong(projectId));
	}

	@Override
	public Project closeOpenProject(String projectId) {
		Project projEntity = marketplaceRepo.findById(Long.parseLong(projectId));
		if(projEntity != null){
			projEntity.setProjectBidStatus("Close");
			projEntity = marketplaceRepo.save(projEntity);
		}
		return projEntity;	
	}

	@Override
	public List<Project> getAllProjects() {
		return marketplaceRepo.findAll();
	}

	@Override
	public List<Bidders> getAllBidders() {
		return bidderRepo.findAll();
	}

}
