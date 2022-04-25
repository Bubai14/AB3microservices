package com.ab3.demo.claimservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClaimserviceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClaimserviceApplication.class);
        String environment = System.getenv("ENV_VAR");
        System.out.println("Environment found:"+ environment);
        app.setAdditionalProfiles(environment);
        app.setLazyInitialization(true);
        app.run(args);
    }

}
