package com.netcracker.backend.service;

import com.netcracker.backend.entity.ProjectsEntity;

public interface ProjectService {

    ProjectsEntity createProject(ProjectsEntity user);
    Iterable<ProjectsEntity> getAllProjects();
    Iterable<ProjectsEntity> getProjectsByAuthorId(long id);
    ProjectsEntity updateProject(ProjectsEntity user);
    void deleteProjectById(long id);

}
