package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.ProjectsEntity;
import com.netcracker.backend.repository.ProjectRepository;
import com.netcracker.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }


    @Override
    public ProjectsEntity createProject(ProjectsEntity user) {
        ProjectsEntity projectsEntity = projectRepository.save(user);
        return projectsEntity;
    }

    @Override
    public Page<ProjectsEntity> getAllProjects(Pageable pageable) {
        Page<ProjectsEntity> projects = projectRepository.findAll(pageable);
        return projects;
    }

    @Override
    public Optional<ProjectsEntity> getProjectByProjectCode(String projectCode) {
        Optional<ProjectsEntity> project = projectRepository.getProjectsEntitiesByCode(projectCode);
        return project;
    }

    @Override
    public  Iterable<ProjectsEntity> getProjectsByAuthorId(long id) {
        Iterable<ProjectsEntity> projects = projectRepository.getProjectsEntitiesByAuthor_AccountId(id);
        return projects;
    }

    @Override
    public ProjectsEntity updateProject(ProjectsEntity project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepository.deleteById(id);
    }
}
