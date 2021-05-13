package com.sebastian.repositories;

import com.sebastian.domain.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AlumnoRepository extends ReactiveCrudRepository<Alumno, String> {

    Flux<Alumno> findAlumnoByNombre(String name);

}
