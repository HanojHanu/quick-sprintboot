package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This annotation let start point of our Spring Boot Application 
@SpringBootApplication
public class CourseApiDataApplication {

	public static void main(String[] args) {
		// create a servlet container and host this application in that servlet container, make it available right!.
		// just you need call one static method run() from static class SpringApplication
		SpringApplication.run(CourseApiDataApplication.class, args);
	}

}
