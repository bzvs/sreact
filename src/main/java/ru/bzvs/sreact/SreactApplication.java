package ru.bzvs.sreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SreactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SreactApplication.class, args);
    }

}
