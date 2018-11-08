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
    public List<ProjectViewModel> getAllProjects() {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] projects = restTemplate.getForObject(backendServerUrl + "/backend/projects/",ProjectViewModel[].class);
        return Arrays.asList(projects);
    }

    @Override
    public List<ProjectViewModel> getProjectsByAuthorId(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] projects = restTemplate.getForObject(backendServerUrl + "/backend/projects/"+id,ProjectViewModel[].class);
        return Arrays.asList(projects);
    }
}
