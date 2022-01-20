package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.springboot.jdbc.h2.example.student.Student;
import com.in28minutes.springboot.jdbc.h2.example.student.StudentJdbcRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication(scanBasePackages = { "com.in28minutes.springboot.rest.example.springboot2jdbcwithh2",
		"com.in28minutes.springboot.jdbc.h2.example.student" })
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 10001 -> {}", repository.findById(10001L));

		logger.info("All users 1 -> {}", repository.findAll());

		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));

		logger.info("Update 10001 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

		repository.deleteById(10002L);

		logger.info("All users 2 -> {}", repository.findAll());
	}

}
