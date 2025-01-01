package com.example.workout_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.workout_app,controllers,repositories"})
@EnableJdbcRepositories(basePackages = "repositories")
public class WorkoutAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutAppApplication.class, args);
	}

}
