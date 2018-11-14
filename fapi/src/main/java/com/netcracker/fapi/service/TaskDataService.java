package com.netcracker.fapi.service;

import com.netcracker.fapi.model.TaskViewModel;

import java.util.List;

public interface TaskDataService {

    List<TaskViewModel> getAll();
    TaskViewModel getTaskByTaskCode(String taskCode);
    TaskViewModel createTask(TaskViewModel task);
    long getCountOfTaskByProjectCode(String projectCode);
    void deleteTask(Long id);
}
