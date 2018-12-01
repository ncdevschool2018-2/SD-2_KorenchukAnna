package com.netcracker.backend.service;

import com.netcracker.backend.entity.TasksEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService {

    TasksEntity createTask(TasksEntity task);
    Page<TasksEntity> getAllTasks(Pageable pageable);
    Optional<TasksEntity> getTaskById(long id);
    Optional<TasksEntity> getTaskByTaskCode(String taskCode);
    long countOfTaskByProjectCode(String taskCode);
    TasksEntity updateTask(TasksEntity task);
    void deleteTask(long id);

}
