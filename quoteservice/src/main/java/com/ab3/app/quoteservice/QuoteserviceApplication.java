package com.ab3.app.quoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuoteserviceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuoteserviceApplication.class);
        String environment = System.getenv("ENV_VAR");
        System.out.println("Environment found:"+ environment);
        app.setAdditionalProfiles(environment);
        app.setLazyInitialization(true);
        app.run(args);
    }

}
