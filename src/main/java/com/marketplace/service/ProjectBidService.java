package com.marketplace.service;

import java.util.List;

import com.marketplace.entity.Bidders;
import com.marketplace.entity.Project;
import com.marketplace.entity.ProjectBids;

public interface ProjectBidService {
	
	public Project createProject(Project project);
	public Project getProjectById(String projectId);
	public ProjectBids bidForProject(com.marketplace.model.ProjectBids projBids);
	public List<Project> getOpenProjects();
	public ProjectBids getLowestBidProject(String projectId);
	public Project closeOpenProject(String projectId);
	public List<Project> getAllProjects();
	public List<Bidders> getAllBidders();
	

}
