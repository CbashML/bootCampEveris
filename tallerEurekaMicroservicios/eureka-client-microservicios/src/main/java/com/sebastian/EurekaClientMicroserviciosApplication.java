package com.sebastian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientMicroserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientMicroserviciosApplication.class, args);
	}

}
