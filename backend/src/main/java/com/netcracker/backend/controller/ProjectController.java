package com.netcracker.backend.controller;

import com.netcracker.backend.entity.ProjectsEntity;
import com.netcracker.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backend/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController( ProjectService projectService){
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProjectsEntity createProject(@RequestBody ProjectsEntity project) {
        return  projectService.createProject(project);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ProjectsEntity> getAllProject() {
        return projectService.getAllProjects();
    }



    @RequestMapping(value = "/{authorId}", method = RequestMethod.GET)
    public Iterable<ProjectsEntity> getProjectByAuthorId(@PathVariable(name = "authorId") long authorId) {
        return projectService.getProjectsByAuthorId(authorId);
    }


}
