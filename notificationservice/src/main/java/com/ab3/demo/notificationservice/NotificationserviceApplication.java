package com.ab3.demo.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class NotificationserviceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NotificationserviceApplication.class);
        String environment = System.getenv("ENV_VAR");
        System.out.println("Environment found:"+ environment);
        app.setAdditionalProfiles(environment);
        app.setLazyInitialization(true);
        app.run(args);
    }

}
