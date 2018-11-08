package com.netcracker.fapi.service;

import com.netcracker.fapi.model.TaskViewModel;

import java.util.List;

public interface TaskDataService {

    List<TaskViewModel> getAll();
    TaskViewModel getTaskByTaskCode(String taskCode);
    void deleteTask(Long id);
}
