package com.netcracker.backend.repository;

import com.netcracker.backend.entity.TasksEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<TasksEntity, Long> {

    public Optional<TasksEntity> findTasksEntitiesByTaskCode(String taskCode);
    long countTasksEntitiesByProjectCode(String projectCode);


}

