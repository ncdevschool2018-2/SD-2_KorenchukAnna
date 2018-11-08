package com.netcracker.backend.repository;

import com.netcracker.backend.entity.ProjectsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectsEntity, Long> {

    Iterable<ProjectsEntity> getProjectsEntitiesByAuthor_AccountId(long authorId);


}

