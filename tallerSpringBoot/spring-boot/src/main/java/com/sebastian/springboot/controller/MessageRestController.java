package com.sebastian.springboot.controller;

import com.sebastian.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    @Autowired
    MessageService messageService;

//    @Value("${course.message}")
//    private String message;

//    @GetMapping(path = "/api/v1/message")
//    public String getMessage(){
//        return "Hello World!";
//    }

//    @GetMapping(path = "/api/v1/message")
//    public String getMessage(){
//        return message;
//    }

    @GetMapping(path = "/api/v1/message")
    public String getMessage(){
        return messageService.getMessage();
    }

}
