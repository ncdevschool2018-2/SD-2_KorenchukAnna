package com.netcracker.fapi.service;

import com.netcracker.fapi.model.ProjectViewModel;

import java.util.List;

public interface ProjectDataService {

    ProjectViewModel createProject(ProjectViewModel user);
    List<ProjectViewModel> getAllProjects();
    List<ProjectViewModel> getProjectsByAuthorId(long id);

}
