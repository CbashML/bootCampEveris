package com.sebastian.eurekaclientmicroservicios2.controller;

import com.sebastian.eurekaclientmicroservicios2.domain.Profesor;
import com.sebastian.eurekaclientmicroservicios2.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping(path = "/api/profesor/{id}")
    public Mono<Profesor> searchById(String id){
        return profesorService.searchById(id);
    }

    @GetMapping(path = "/api/profesor/{name}")
    public Mono<Profesor> searchByName(@RequestParam(value="name") String name){
        return profesorService.searchByName(name);
    }

    @GetMapping(path = "/api/profesores")
    public Flux<Profesor> searchAll(){
        return profesorService.searchAll();
    }

    @PostMapping(path = "/api/createProfesor")
    public Mono<Profesor> createProfesor(Profesor p){
        return profesorService.createProfesor(p);
    }


}
