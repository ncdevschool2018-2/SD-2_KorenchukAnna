package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.PriorityViewModel;
import com.netcracker.fapi.service.PriorityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/priority")
public class PriorityDataController {

    @Autowired
    private PriorityDataService priorityDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PriorityViewModel>> getAllPriorities() {
        List<PriorityViewModel> priorities = priorityDataService.getAll();
        return ResponseEntity.ok().body(priorities);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<PriorityViewModel> getPriorityById(@PathVariable Long id) {
        return ResponseEntity.ok(priorityDataService.getPriorityById(id));
    }

}
