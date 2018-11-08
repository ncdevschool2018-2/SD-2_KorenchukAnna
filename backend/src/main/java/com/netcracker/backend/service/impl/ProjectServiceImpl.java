package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.ProjectsEntity;
import com.netcracker.backend.repository.ProjectRepository;
import com.netcracker.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Iterable<ProjectsEntity> getAllProjects() {
        Iterable<ProjectsEntity> projects = projectRepository.findAll();
        return projects;
    }

    @Override
    public  Iterable<ProjectsEntity> getProjectsByAuthorId(long id) {
        Iterable<ProjectsEntity> projects = projectRepository.getProjectsEntitiesByAuthor_AccountId(id);
        return projects;
    }

    @Override
    public ProjectsEntity updateProject(ProjectsEntity user) {
        return null;
    }

    @Override
    public void deleteProjectById(long id) {

    }
}
