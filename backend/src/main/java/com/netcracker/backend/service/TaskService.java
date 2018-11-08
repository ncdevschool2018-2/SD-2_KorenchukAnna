package com.netcracker.backend.service;

import com.netcracker.backend.entity.TasksEntity;

import java.util.Optional;

public interface TaskService {

    TasksEntity createTask(TasksEntity task);
    Iterable<TasksEntity> getAllTasks();
    Optional<TasksEntity> getTaskById(long id);
    Optional<TasksEntity> getTaskByTaskCode(String taskCode);
    long countOfTaskByProjectCode(String taskCode);
    TasksEntity updateTask(TasksEntity task);
    void deleteTask(long id);

}
