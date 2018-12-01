package com.netcracker.fapi.service.impl;

import com.netcracker.fapi.model.ProjectViewModel;
import com.netcracker.fapi.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ProjectViewModel createProject(ProjectViewModel project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/backend/projects", project, ProjectViewModel.class).getBody();
    }

    @Override
    public List<ProjectViewModel> getAllProjects(int page,int size) {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] projects = restTemplate.getForObject(backendServerUrl + "/backend/projects?"+"page="+page+"&&"+"size="+size,ProjectViewModel[].class);
        return Arrays.asList(projects);
    }

    @Override
    public ProjectViewModel getProjectByProjectCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel project = restTemplate.getForObject(backendServerUrl + "/backend/projects/projectCode/"+code, ProjectViewModel.class);
        return project;
    }

    @Override
    public void updateProject(ProjectViewModel project) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(backendServerUrl + "/backend/projects",project);
    }

    @Override
    public void deleteProject(long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/backend/projects/" + id);
    }


    @Override
    public List<ProjectViewModel> getProjectsByAuthorId(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] projects = restTemplate.getForObject(backendServerUrl + "/backend/projects/authorId/"+id,ProjectViewModel[].class);
        return Arrays.asList(projects);
    }
}
