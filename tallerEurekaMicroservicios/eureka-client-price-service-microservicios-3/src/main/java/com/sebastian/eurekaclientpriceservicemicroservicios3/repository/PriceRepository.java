package com.sebastian.eurekaclientpriceservicemicroservicios3.repository;

import com.sebastian.eurekaclientpriceservicemicroservicios3.domain.Price;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PriceRepository extends ReactiveCrudRepository<Price, String> {

//    public Mono<Price> findByPoduct(String product);

}
