package com.sebastian.eurekaclientpriceservicemicroservicios3.controller;

import com.sebastian.eurekaclientpriceservicemicroservicios3.domain.Price;
import com.sebastian.eurekaclientpriceservicemicroservicios3.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping(path = "/api/prices")
    public Flux<Price> searchAll(){
        return priceService.findAll();
    }

    @PostMapping(path = "/api/price")
    public Mono<Price> createPrecio(Price p){
        return priceService.insert(p);
    }

    @GetMapping(path = "/api/price/{id}")
    public Mono<Price> searchById(String id){
        return priceService.findOne(id);
    }

}
