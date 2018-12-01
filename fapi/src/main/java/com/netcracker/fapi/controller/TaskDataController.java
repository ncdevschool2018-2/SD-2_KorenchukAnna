package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.TaskViewModel;
import com.netcracker.fapi.service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskDataController {

    @Autowired
    private TaskDataService taskDataService;

    @RequestMapping(value = "", params = {"page","size"},method = RequestMethod.GET)
    public ResponseEntity<List<TaskViewModel>> getAllTasks(@RequestParam("page") int page,@RequestParam("size")int size) {
        List<TaskViewModel> tasks = taskDataService.getAll(page,size);
        return ResponseEntity.ok().body(tasks);
    }

    @RequestMapping(value = "/{taskCode}",method = RequestMethod.GET)
    public ResponseEntity<TaskViewModel> getTaskByTaskCode(@PathVariable String taskCode) {
        return ResponseEntity.ok(taskDataService.getTaskByTaskCode(taskCode));
    }

    @RequestMapping(value = "/projectCode/{projectCode}",method = RequestMethod.GET)
    public ResponseEntity<Long> getCountOfTaskByProjectCode(@PathVariable String projectCode) {
        return ResponseEntity.ok(taskDataService.getCountOfTaskByProjectCode(projectCode));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TaskViewModel> createTask(@RequestBody TaskViewModel task ) {
        if (task != null) {
            return ResponseEntity.ok(taskDataService.createTask(task));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable long id) {
        taskDataService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<TaskViewModel> updateTask(@RequestBody TaskViewModel task) {
        if (task != null) {
            taskDataService.updateTask(task);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
