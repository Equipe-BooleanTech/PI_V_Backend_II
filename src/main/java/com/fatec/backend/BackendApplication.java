package com.fatec.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        System.out.println("JDBC URL: " + System.getenv("POSTGRES_URL"));
        SpringApplication.run(BackendApplication.class, args);
    }

}
