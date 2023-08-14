package com.test.cm2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.test.cm2")
public class Cm2Application {

    public static void main(String[] args) {
        SpringApplication.run(Cm2Application.class, args);
    }

}


