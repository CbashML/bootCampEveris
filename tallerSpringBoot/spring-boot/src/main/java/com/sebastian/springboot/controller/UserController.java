package com.sebastian.springboot.controller;

import com.sebastian.springboot.domain.User;
import com.sebastian.springboot.service.UserService;
import io.swagger.annotations.Api;
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
    public User createUser(@PathVariable("birth_date") LocalDate birthDate){
        return userService.createUser(birthDate);
    }

    @GetMapping(path = "/api/v1/users/{id}")
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/api/v1/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping (path = "/api/v1/users")
    public User updateUser(Integer id, LocalDate birthDate){
        return userService.updateUser(id, birthDate);
    }

    @DeleteMapping(path = "/api/v1/users/{id}")
    public void deleteUserById(Integer id){
        userService.deleteUserById(id);
    }


}
