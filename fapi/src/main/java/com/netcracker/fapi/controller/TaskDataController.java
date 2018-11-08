package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.TaskViewModel;
import com.netcracker.fapi.service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskDataController {

    @Autowired
    private TaskDataService taskDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TaskViewModel>> getAllTasks() {
        List<TaskViewModel> tasks = taskDataService.getAll();
        return ResponseEntity.ok().body(tasks);
    }

    @RequestMapping(value = "/{taskCode}",method = RequestMethod.GET)
    public ResponseEntity<TaskViewModel> getTaskByTaskCode(@PathVariable String taskCode) {
        return ResponseEntity.ok(taskDataService.getTaskByTaskCode(taskCode));
    }

}
