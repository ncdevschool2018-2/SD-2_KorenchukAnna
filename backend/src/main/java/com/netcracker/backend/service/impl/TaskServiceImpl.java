package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.TasksEntity;
import com.netcracker.backend.repository.TaskRepository;
import com.netcracker.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }


    @Override
    public TasksEntity createTask(TasksEntity task) {
        TasksEntity issues = taskRepository.save(task);
        return issues;
    }

    @Override
    public Page<TasksEntity> getAllTasks(Pageable pageable) {
        Page<TasksEntity> tasks = taskRepository.findAll(pageable);
        return tasks;
    }

    @Override
    public Optional<TasksEntity> getTaskById(long id) {
        Optional<TasksEntity> task = taskRepository.findById(id);
        return task;
    }

    @Override
    public Optional<TasksEntity> getTaskByTaskCode(String taskCode) {
        Optional<TasksEntity> task = taskRepository.findTasksEntitiesByTaskCode(taskCode);
        return task;
    }

    @Override
    public long countOfTaskByProjectCode(String projectCode) {
        return  taskRepository.countTasksEntitiesByProjectCode(projectCode);
    }

    @Override
    public TasksEntity updateTask(TasksEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
