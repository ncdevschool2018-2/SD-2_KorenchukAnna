package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.ProjectViewModel;
import com.netcracker.fapi.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectDataController {

    @Autowired
    private ProjectDataService projectDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProjectViewModel> createProject(@RequestBody ProjectViewModel project) {
        if (project != null) {
            return ResponseEntity.ok(projectDataService.createProject(project));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProjectViewModel>> getAllProjects() {
        List<ProjectViewModel> projects = projectDataService.getAllProjects();
        return ResponseEntity.ok().body(projects);
    }

    @RequestMapping(value = "/{authorId}",method = RequestMethod.GET)
    public ResponseEntity<List<ProjectViewModel>> getProjectsByAuthorId(long id) {
        List<ProjectViewModel> projects = projectDataService.getProjectsByAuthorId(id);
        return ResponseEntity.ok().body(projects);
    }
}
