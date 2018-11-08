package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.StatusViewModel;
import com.netcracker.fapi.service.StatusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusDataController {

    @Autowired
    private StatusDataService statusDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StatusViewModel>> getAllStatus() {
        List<StatusViewModel> status = statusDataService.getAll();
        return ResponseEntity.ok().body(status);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<StatusViewModel> getStatusById(@PathVariable Long id) {
        return ResponseEntity.ok(statusDataService.getStatusById(id));
    }

}
