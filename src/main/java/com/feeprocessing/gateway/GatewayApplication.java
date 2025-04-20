package com.feeprocessing.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	
	 @Bean
	 public RouteLocator routeLocator(RouteLocatorBuilder builder) {
	  return builder
	    .routes()
	    .route("student-service", r -> r.path("/student-service/**")
                .uri("lb://student-service"))
	    .route("catalog-service", r -> r.path("/catalog-service/**")
                .uri("lb://catalog-service"))
	    .route("fee-service", r -> r.path("/fee-service/**")
                .uri("lb://fee-service"))
	    .build();
	 }
}
