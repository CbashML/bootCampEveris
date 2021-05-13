package com.sebastian.eurekaclientpriceservicemicroservicios3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientPriceServiceMicroservicios3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientPriceServiceMicroservicios3Application.class, args);
	}

}
