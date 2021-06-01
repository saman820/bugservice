package com.example;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BugService1Application {
	

	

	public static void main(String[] args) {
		SpringApplication.run(BugService1Application.class, args);
	}

}
