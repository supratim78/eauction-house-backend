package com.cts.eauction.microservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@EnableBinding(Source.class)
@EnableEurekaClient
@SpringBootApplication
public class EauctionHouseProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EauctionHouseProductServiceApplication.class, args);
		
		/*
		 * @SuppressWarnings("deprecation")
		 * 
		 * @Configuration
		 * 
		 * @EnableBinding(Source.class) class StreamConfig{
		 * 
		 * }
		 */
	}

}
