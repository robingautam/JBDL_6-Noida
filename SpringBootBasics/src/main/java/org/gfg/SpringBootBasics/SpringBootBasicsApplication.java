package org.gfg.SpringBootBasics;


import org.gfg.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "org.gfg")
public class SpringBootBasicsApplication implements CommandLineRunner {

	@Autowired
	Student student;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(student);
	}
}
