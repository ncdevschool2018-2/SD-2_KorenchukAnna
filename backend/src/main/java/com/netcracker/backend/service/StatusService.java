package com.netcracker.backend.service;

import com.netcracker.backend.entity.StatusEntity;

import java.util.Optional;

public interface StatusService {
    StatusEntity createStatus(StatusEntity status);
    Iterable<StatusEntity> getAllStatus();
    Optional<StatusEntity> getStatusById(long id);
    StatusEntity updateStatus(StatusEntity status);
    void deleteStatusById(long id);

}
