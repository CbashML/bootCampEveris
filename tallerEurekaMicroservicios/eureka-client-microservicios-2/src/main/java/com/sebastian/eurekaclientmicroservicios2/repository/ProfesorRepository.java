package com.sebastian.eurekaclientmicroservicios2.repository;

import com.sebastian.eurekaclientmicroservicios2.domain.Profesor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProfesorRepository extends ReactiveCrudRepository<Profesor, String> {

    public Mono<Profesor> findByNombre(String nombre);

}
