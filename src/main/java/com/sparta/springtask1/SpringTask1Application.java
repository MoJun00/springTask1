package com.sparta.springtask1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringTask1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTask1Application.class, args);
    }

}
