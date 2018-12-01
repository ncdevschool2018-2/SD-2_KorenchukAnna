package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.RolesEntity;
import com.netcracker.backend.repository.RoleRepository;
import com.netcracker.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public RolesEntity createRole(RolesEntity role) {
        RolesEntity rolesEntity = roleRepository.save(role);
        return rolesEntity;
    }

    @Override
    public Iterable<RolesEntity> getAllRoles() {
        Iterable<RolesEntity> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    public Optional<RolesEntity> getRoleById(long id) {
        Optional<RolesEntity> rolesEntity = roleRepository.findById(id);
        return rolesEntity;
    }

    @Override
    public RolesEntity updatePriority(RolesEntity role) {
        return null;
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }
}
