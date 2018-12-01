package com.netcracker.backend.repository;

import com.netcracker.backend.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TasksEntity, Long> {

    Optional<TasksEntity> findTasksEntitiesByTaskCode(String taskCode);
    long countTasksEntitiesByProjectCode(String projectCode);


}

