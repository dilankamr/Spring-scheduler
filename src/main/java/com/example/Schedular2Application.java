package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Schedular2Application {

	public static void main(String[] args) {
		SpringApplication.run(Schedular2Application.class, args);
	}
}
