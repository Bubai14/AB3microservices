package com.ab3.app.policyservice;

import com.ab3.app.policyservice.config.SSHConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({SSHConnection.class})
@SpringBootApplication
public class PolicyserviceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PolicyserviceApplication.class);
        String environment = System.getenv("ENV_VAR");
        System.out.println("Environment found:"+ environment);
        app.setAdditionalProfiles(environment);
        app.setLazyInitialization(true);
        app.run(args);
    }

}
