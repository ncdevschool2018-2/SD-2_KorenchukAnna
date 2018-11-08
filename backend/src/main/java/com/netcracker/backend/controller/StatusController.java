package com.netcracker.backend.controller;

import com.netcracker.backend.entity.StatusEntity;
import com.netcracker.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/backend/status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    StatusController( StatusService statusService){
        this.statusService = statusService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StatusEntity> getStatusByLogin(@PathVariable(name = "id") long id) {
        Optional<StatusEntity> status = statusService.getStatusById(id);
        if(status.isPresent())
            return ResponseEntity.ok().body(status.get());
        else
            return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StatusEntity> getAllStatus() {
        return statusService.getAllStatus();
    }




}
