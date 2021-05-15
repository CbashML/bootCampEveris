package com.sebastian.springboot.controller;

import com.sebastian.springboot.domain.User;
import com.sebastian.springboot.service.UserService;
import io.swagger.annotations.*;
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
    @ApiResponses ({
        @ApiResponse(code = 200, message = "User created correctly"),
    })
    public User createUser(@ApiParam(value = "The id of the user", required = true) @PathVariable("birth_date") LocalDate birthDate){
        return userService.createUser(birthDate);
    }

    @GetMapping(path = "/api/v1/users/{id}")
    @ApiOperation("Find a user by an given id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "User not found.")
    })
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/api/v1/users")
    @ApiOperation("Find all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Users not found.")
    })
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping (path = "/api/v1/users")
    @ApiOperation("Upadte a user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User updated correctly"),
            @ApiResponse(code = 404, message = "Users not found.")
    })
    public User updateUser(Integer id, LocalDate birthDate){
        return userService.updateUser(id, birthDate);
    }

    @DeleteMapping(path = "/api/v1/users/{id}")
    @ApiOperation("Delete an user by a given id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Users not found.")
    })
    public void deleteUserById(Integer id){
        userService.deleteUserById(id);
    }

}
