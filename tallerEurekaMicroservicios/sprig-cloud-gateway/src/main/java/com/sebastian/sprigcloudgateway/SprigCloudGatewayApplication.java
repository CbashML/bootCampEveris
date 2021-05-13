package com.sebastian.sprigcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SprigCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprigCloudGatewayApplication.class, args);
	}

}
