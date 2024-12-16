package com.example.WindSpeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println(" _      _______  _____  _______  ___________");
		System.out.println("| | /| / /  _/ \\/ / _ \\/ __/ _ \\/ __/ __/ _ \\");
		System.out.println("| |/ |/ // //    / // /\\ \\/ ___/ _// _// // /");
		System.out.println("|__/|__/___/_/|_/____/___/_/  /___/___/____/");
		System.out.println("                                     (v1.2)");
		System.out.println("Windspeed API is running at http://localhost:8080");
	}
}