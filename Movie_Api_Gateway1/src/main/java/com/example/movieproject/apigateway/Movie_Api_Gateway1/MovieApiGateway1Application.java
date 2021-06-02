package com.example.movieproject.apigateway.Movie_Api_Gateway1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MovieApiGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiGateway1Application.class, args);
	}

}
