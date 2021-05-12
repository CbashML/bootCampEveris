package com.sebastian.controller;

import com.sebastian.domain.Alumno;
import com.sebastian.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping(path="/api/search/{id}")
    public Mono<Alumno> searchById(@PathVariable String id){
        return alumnoService.searchById(id);
    }

    @GetMapping(path="/api/alumnos")
    public Flux<Alumno> searchAll(){
        return alumnoService.searchAll();
    }

    @PostMapping(path="/api/insert" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Alumno> createAlumno(@RequestBody Alumno a){
        return alumnoService.createAlumno(a);
    }



}
