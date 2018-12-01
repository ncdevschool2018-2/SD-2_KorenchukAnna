package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.ProjectViewModel;
import com.netcracker.fapi.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ProjectViewModel> updateProject(@RequestBody ProjectViewModel project) {
        if (project != null) {
            projectDataService.updateProject(project);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "", params = {"page","size"},method = RequestMethod.GET)
    public ResponseEntity<List<ProjectViewModel>> getAllProjects(@RequestParam("page") int page,@RequestParam("size")int size ) {
        List<ProjectViewModel> projects = projectDataService.getAllProjects(page,size);
        return ResponseEntity.ok().body(projects);
    }

    @RequestMapping(value = "/projectCode/{projectCode}", method = RequestMethod.GET)
    public ResponseEntity<ProjectViewModel> getProjectByProjectCode(@PathVariable(name = "projectCode") String projectCode) {
       return ResponseEntity.ok().body(projectDataService.getProjectByProjectCode(projectCode));
    }

    @RequestMapping(value = "/authorId/{authorId}",method = RequestMethod.GET)
    public ResponseEntity<List<ProjectViewModel>> getProjectsByAuthorId(long id) {
        List<ProjectViewModel> projects = projectDataService.getProjectsByAuthorId(id);
        return ResponseEntity.ok().body(projects);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProject(@PathVariable long id) {
        projectDataService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
