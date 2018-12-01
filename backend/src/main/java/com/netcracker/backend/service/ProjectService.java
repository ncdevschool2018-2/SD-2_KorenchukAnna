package com.netcracker.backend.service;

import com.netcracker.backend.entity.ProjectsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProjectService {

    ProjectsEntity createProject(ProjectsEntity user);
    Page<ProjectsEntity> getAllProjects(Pageable pageable);
    Optional<ProjectsEntity> getProjectByProjectCode(String projectCode);
    Iterable<ProjectsEntity> getProjectsByAuthorId(long id);
    ProjectsEntity updateProject(ProjectsEntity project);
    void deleteProjectById(long id);

}
