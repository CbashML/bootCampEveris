package com.sebastian.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service


public class MessageService {

    @Value("${course.message}")
    private String message;

    public String getMessage(){
        return message;
    }

}
