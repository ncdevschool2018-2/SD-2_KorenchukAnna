package com.netcracker.backend.controller;

import com.netcracker.backend.entity.TasksEntity;
import com.netcracker.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/backend/tasks")
public class TaskController {

    public final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TasksEntity> getAllTask() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/{taskCode}", method = RequestMethod.GET)
    public ResponseEntity<TasksEntity> getTaskByTaskCode(@PathVariable(name = "taskCode")String taskCode) {
        Optional<TasksEntity> task = taskService.getTaskByTaskCode(taskCode);
        if(task.isPresent())
            return ResponseEntity.ok().body(task.get());
        else
            return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/count/{projectCode}", method = RequestMethod.GET)
    public ResponseEntity<Long> getCountOfTaskByProjectCode(@PathVariable(name = "projectCode") String projectCode){
        return  ResponseEntity.ok().body(taskService.countOfTaskByProjectCode(projectCode));
    }
}
