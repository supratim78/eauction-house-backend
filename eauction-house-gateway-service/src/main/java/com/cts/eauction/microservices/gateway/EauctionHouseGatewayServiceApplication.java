package com.cts.eauction.microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EauctionHouseGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EauctionHouseGatewayServiceApplication.class, args);
	}

}
