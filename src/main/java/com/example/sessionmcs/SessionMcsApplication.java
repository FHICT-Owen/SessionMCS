package com.example.sessionmcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SessionMcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionMcsApplication.class, args);
    }

}
