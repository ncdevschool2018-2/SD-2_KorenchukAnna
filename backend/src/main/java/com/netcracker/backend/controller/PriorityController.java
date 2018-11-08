package com.netcracker.backend.controller;


import com.netcracker.backend.entity.PrioritiesEntity;
import com.netcracker.backend.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/backend/priority")
public class PriorityController {

    private final PriorityService priorityService;

    @Autowired
    PriorityController( PriorityService priorityService){
        this.priorityService = priorityService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PrioritiesEntity> getPriorityById(@PathVariable(name = "id") long id) {
        Optional<PrioritiesEntity> priority = priorityService.getPriorityById(id);
        if(priority.isPresent())
            return ResponseEntity.ok().body(priority.get());
        else
            return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PrioritiesEntity> getAllPriorities() {
        return priorityService.getAllPriorities();
    }
}
