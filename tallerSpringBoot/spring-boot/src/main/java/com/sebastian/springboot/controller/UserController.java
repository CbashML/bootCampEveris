package com.sebastian.springboot.controller;

import com.sebastian.springboot.domain.User;
import com.sebastian.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Api
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/api/v1/users")
    @ApiOperation("Create a new instances of User type into DB.")
    public User createUser(@PathVariable("birth_date") LocalDate birthDate){
        return userService.createUser(birthDate);
    }

    @GetMapping(path = "/api/v1/users/{id}")
    @ApiOperation("Find a user by an given id")
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/api/v1/users")
    @ApiOperation("Find all users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping (path = "/api/v1/users")
    @ApiOperation("Upadte a user")
    public User updateUser(Integer id, LocalDate birthDate){
        return userService.updateUser(id, birthDate);
    }

    @DeleteMapping(path = "/api/v1/users/{id}")
    @ApiOperation("Delete an user by a given id")
    public void deleteUserById(Integer id){
        userService.deleteUserById(id);
    }

}
