package com.marketplace.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marketplace.model.Bidders;
import com.marketplace.model.Project;
import com.marketplace.model.ProjectBids;
import com.marketplace.service.ProjectBidService;

@Controller
public class ProjectBidController {
	
	@Autowired
	private ProjectBidService projectBidService;
	
	@RequestMapping(value="/api/createProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Project createProject(@RequestBody Project projectRequest){
		try {
			com.marketplace.entity.Project projectEntity = projectBidService.createProject(convertToEntity(projectRequest));
			return convertToDto(projectEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Project();
		}
	}
	
	@RequestMapping(value="/api/bidProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProjectBids bidProject(@RequestBody ProjectBids projectRequpbRequest){
		return convertToDto(projectBidService.bidForProject(projectRequpbRequest));
	}
	
	@RequestMapping(value="/api/getLowestBid", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProjectBids getLowestBidProject(@RequestBody Project projectRequest){
		if(projectRequest.getProjectId() != null && projectRequest.getProjectId().length() > 0){
			com.marketplace.entity.ProjectBids projectBid = projectBidService.getLowestBidProject(projectRequest.getProjectId());
			if(projectBid != null)
				return convertToDto(projectBid);
			else
				return new ProjectBids();
		}else
			return new ProjectBids();
		
		
	}
	
	@RequestMapping(value="/api/getOpenProjects", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getOpenProjects(){
		
		List<Project> openProjectList = new ArrayList<Project>();
		
		List<com.marketplace.entity.Project> projEntityList = projectBidService.getOpenProjects();
		
		for(com.marketplace.entity.Project projEntity:projEntityList){
			Project projDto = convertToDto(projEntity);
			openProjectList.add(projDto);
		}
		return openProjectList;
	}
	
	@RequestMapping(value="/api/closeBidStatus", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Project closeOpenProjects(@RequestBody Project project){
		if(project.getProjectId() != null && project.getProjectId().length() > 0){
			com.marketplace.entity.Project projEntity = projectBidService.closeOpenProject(project.getProjectId());
			if(projEntity != null){
				return convertToDto(projEntity);
			}else{
				return new Project();
			}
		}else
			return new Project();
	}
	
	@RequestMapping(value="/api/getAllProjects", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getAllProjects(){
		
		List<Project> allProjectsList = new ArrayList<Project>();
		
		List<com.marketplace.entity.Project> projEntityList = projectBidService.getAllProjects();
		
		for(com.marketplace.entity.Project projEntity:projEntityList){
			Project projDto = convertToDto(projEntity);
			allProjectsList.add(projDto);
		}
		return allProjectsList;
	}
	
	@RequestMapping(value="/api/getAllBidders", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Bidders> getAllBidders(){
		
		List<Bidders> allBiddersList = new ArrayList<Bidders>();
		
		List<com.marketplace.entity.Bidders> biddersEntityList = projectBidService.getAllBidders();
		
		for(com.marketplace.entity.Bidders bidderEntity:biddersEntityList){
			Bidders bidderDto = convertToDto(bidderEntity);
			allBiddersList.add(bidderDto);
		}
		return allBiddersList;
	}
	
	
	private com.marketplace.entity.Project convertToEntity(Project projectDto) throws ParseException{
		ModelMapper modelMapper = new ModelMapper();
		com.marketplace.entity.Project projectEntity = modelMapper.map(projectDto, com.marketplace.entity.Project.class);
		return projectEntity;
	}
	
	private Project convertToDto(com.marketplace.entity.Project projectEntity){
		ModelMapper modelMapper = new ModelMapper();
		Project projectDto = modelMapper.map(projectEntity, Project.class);
		return projectDto;
	}
	
	private Bidders convertToDto(com.marketplace.entity.Bidders bidderEntity){
		ModelMapper modelMapper = new ModelMapper();
		Bidders bidderDto = modelMapper.map(bidderEntity, Bidders.class);
		return bidderDto;
	}
	
	private ProjectBids convertToDto(com.marketplace.entity.ProjectBids projectBidsEntity){
		ModelMapper modelMapper = new ModelMapper();
		ProjectBids projectBidsDto = modelMapper.map(projectBidsEntity, ProjectBids.class);
		return projectBidsDto;
	}
}
