package com.netcracker.fapi.service;

import com.netcracker.fapi.model.ProjectViewModel;

import java.util.List;

public interface ProjectDataService {

    ProjectViewModel createProject(ProjectViewModel user);
    List<ProjectViewModel> getAllProjects(int page,int size);
    List<ProjectViewModel> getProjectsByAuthorId(long id);
    ProjectViewModel getProjectByProjectCode(String code);
    void updateProject(ProjectViewModel account);
    void deleteProject(long id);

}
