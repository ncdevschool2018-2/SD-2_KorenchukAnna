package com.netcracker.backend.controller;

import com.netcracker.backend.entity.ProjectsEntity;
import com.netcracker.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public Iterable<ProjectsEntity> getAllProject(Pageable pageable) {
        return projectService.getAllProjects(pageable).getContent();
    }

    @RequestMapping(value = "/projectCode/{projectCode}", method = RequestMethod.GET)
    public ResponseEntity<ProjectsEntity> getProjectByProjectCode(@PathVariable(name = "projectCode") String projectCode) {
        Optional<ProjectsEntity> projectEntity = projectService.getProjectByProjectCode(projectCode);
        if(projectEntity.isPresent())
            return ResponseEntity.ok().body(projectEntity.get());
        else
            return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/authorId/{authorId}", method = RequestMethod.GET)
    public Iterable<ProjectsEntity> getProjectByAuthorId(@PathVariable(name = "authorId") long authorId) {
        return projectService.getProjectsByAuthorId(authorId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProjectById(@PathVariable(name="id") Long id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProjectsEntity updateProject(@RequestBody ProjectsEntity project) {
        return  projectService.updateProject(project);
    }

}
