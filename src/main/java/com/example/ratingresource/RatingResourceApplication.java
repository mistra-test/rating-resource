package com.example.ratingresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RatingResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingResourceApplication.class, args);
    }
}
