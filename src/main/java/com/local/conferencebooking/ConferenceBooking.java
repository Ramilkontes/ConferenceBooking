package com.local.conferencebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.local.conferencebooking.models")
@ComponentScan(basePackages = "com.local.conferencebooking")
@EnableJpaRepositories(basePackages = "com.local.conferencebooking.repositories")
public class ConferenceBooking {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceBooking.class);
    }
}
