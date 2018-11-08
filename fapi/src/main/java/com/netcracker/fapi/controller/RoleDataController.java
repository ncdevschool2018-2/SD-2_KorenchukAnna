package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.RoleViewModel;
import com.netcracker.fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleDataController {

    @Autowired
    private RoleDataService roleDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RoleViewModel>> getAllRolies() {
        List<RoleViewModel> rolies = roleDataService.getAll();
        return ResponseEntity.ok().body(rolies);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<RoleViewModel> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(roleDataService.getRoleById(id));
    }

}
