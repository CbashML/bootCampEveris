package com.sebastian.eurekaclientmicroservicios2.service;

import com.netflix.discovery.converters.Auto;
import com.sebastian.eurekaclientmicroservicios2.domain.Profesor;
import com.sebastian.eurekaclientmicroservicios2.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    public Mono<Profesor> searchById(String id){
        return profesorRepository.findById(id);
    }

    public Mono<Profesor> searchByName(String name){
        return profesorRepository.findByNombre(name);
    }

    public Mono<Profesor> createProfesor(Profesor p){
        return profesorRepository.save(p);
    }

    public Flux<Profesor> searchAll(){
        return profesorRepository.findAll();
    }


}
