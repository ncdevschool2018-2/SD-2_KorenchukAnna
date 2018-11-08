package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.UserViewModel;
import com.netcracker.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserViewModel>> getAllTasks() {
        List<UserViewModel> users = userDataService.getAll();
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value = "/id/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userDataService.getUserById(id));
    }

    @RequestMapping(value = "/accountId/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getUserByAccountId(@PathVariable Long id) {
        return ResponseEntity.ok(userDataService.getUserByAccountId(id));
    }
}
