package com.netcracker.backend.controller;

import com.netcracker.backend.entity.RolesEntity;
import com.netcracker.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/backend/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    RoleController(RoleService roleService){
        this.roleService = roleService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public RolesEntity createRole(@RequestBody RolesEntity role) {
        return  roleService.createRole(role);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<RolesEntity> getAllRoles() {
        return roleService.getAllRoles();
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  ResponseEntity<RolesEntity> getRoleById(@PathVariable(name = "id") long id) {
        Optional<RolesEntity> rolesEntity = roleService.getRoleById(id);
        if(rolesEntity.isPresent())
            return ResponseEntity.ok().body(rolesEntity.get());
        else
            return ResponseEntity.noContent().build();

    }


}
