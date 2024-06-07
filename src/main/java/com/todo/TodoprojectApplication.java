package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TodoprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoprojectApplication.class, args);
	}
}
