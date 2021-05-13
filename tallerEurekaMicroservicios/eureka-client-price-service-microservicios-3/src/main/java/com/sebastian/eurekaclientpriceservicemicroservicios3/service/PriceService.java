package com.sebastian.eurekaclientpriceservicemicroservicios3.service;

import com.sebastian.eurekaclientpriceservicemicroservicios3.domain.Price;
import com.sebastian.eurekaclientpriceservicemicroservicios3.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public Flux<Price> findAll(){
        return priceRepository.findAll();
    }

    public Mono<Price> findOne(String productId){
        return priceRepository.findById(productId);
    }

    public Mono<Price> insert(Price price){
        return priceRepository.save(price);
    }

}
