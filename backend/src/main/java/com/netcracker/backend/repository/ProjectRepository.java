package com.netcracker.backend.repository;

import com.netcracker.backend.entity.ProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<ProjectsEntity, Long> {

    Iterable<ProjectsEntity> getProjectsEntitiesByAuthor_AccountId(long authorId);
    Optional<ProjectsEntity> getProjectsEntitiesByCode(String code);


}

