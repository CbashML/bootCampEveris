package com.sebastian.service;

import com.sebastian.domain.Alumno;
import com.sebastian.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    public Mono<Alumno> searchById(String id){
       return alumnoRepository.findById(id);
    }

    public Mono<Alumno> createAlumno(Alumno a){
        return alumnoRepository.save(a);
    }

    public Flux<Alumno> searchAll(){
        return alumnoRepository.findAll();
    }


}
