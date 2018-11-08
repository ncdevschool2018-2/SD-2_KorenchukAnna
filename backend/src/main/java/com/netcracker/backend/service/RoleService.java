package com.netcracker.backend.service;

import com.netcracker.backend.entity.RolesEntity;

import java.util.Optional;

public interface RoleService {
    RolesEntity createRole(RolesEntity role);
    Iterable<RolesEntity> getAllRoles();
    Optional<RolesEntity> getRoleById(long id);
    RolesEntity updatePriority(RolesEntity role);
    void deleteRoleById(long id);

}
