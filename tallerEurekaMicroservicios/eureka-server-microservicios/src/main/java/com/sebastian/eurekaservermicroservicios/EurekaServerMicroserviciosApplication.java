package com.sebastian.eurekaservermicroservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMicroserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMicroserviciosApplication.class, args);
	}

}
