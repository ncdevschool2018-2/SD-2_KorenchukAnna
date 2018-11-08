package com.netcracker.backend.controller;

import com.netcracker.backend.entity.UsersEntity;
import com.netcracker.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/backend/users")
public class UserController {

    public final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsersEntity> getUserById(@PathVariable(name = "id") long id) {
        Optional<UsersEntity> user = userService.getUserById(id);
        if(user.isPresent())
            return ResponseEntity.ok().body(user.get());
        else
            return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UsersEntity> getAllUsers() {
        return userService.getAllUsers();
    }

}
