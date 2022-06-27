package com.cts.eauction.microservices.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EauctionHouseDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EauctionHouseDiscoveryServiceApplication.class, args);
	}

}
