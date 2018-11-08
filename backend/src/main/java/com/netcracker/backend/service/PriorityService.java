package com.netcracker.backend.service;

import com.netcracker.backend.entity.PrioritiesEntity;

import java.util.Optional;

public interface PriorityService {
    PrioritiesEntity createPriority(PrioritiesEntity priority);
    Iterable<PrioritiesEntity> getAllPriorities();
    Optional<PrioritiesEntity> getPriorityById(long id);
    PrioritiesEntity updatePriority(PrioritiesEntity priority);
    void deletePriorityById(long id);

}
