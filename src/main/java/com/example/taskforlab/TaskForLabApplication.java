package com.example.taskforlab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Post Service",
				version = "1.0.0",
				description = "OpenApi documentation for Post Service"
		)
)
public class TaskForLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskForLabApplication.class, args);
	}

}
