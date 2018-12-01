package com.netcracker.backend.controller;

import com.netcracker.backend.entity.TasksEntity;
import com.netcracker.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<TasksEntity> getAllTask(Pageable pageable) {
        return taskService.getAllTasks(pageable).getContent();
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

    @RequestMapping(method = RequestMethod.POST)
    public TasksEntity createTask(@RequestBody TasksEntity task) {
        return  taskService.createTask(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTaskById(@PathVariable(name="id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TasksEntity updateTask(@RequestBody TasksEntity task) {
        return  taskService.updateTask(task);
    }

}
