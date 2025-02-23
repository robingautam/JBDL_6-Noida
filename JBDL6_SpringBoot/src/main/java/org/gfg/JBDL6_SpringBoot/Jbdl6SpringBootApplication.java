package org.gfg.JBDL6_SpringBoot;

import org.gfg.JBDL6_SpringBoot.profile.DatabaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

//@SpringBootApplication(exclude = {DispatcherServletAutoConfiguration.class, ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class Jbdl6SpringBootApplication implements CommandLineRunner {

	@Autowired
	DatabaseConfiguration databaseConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(Jbdl6SpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		databaseConfiguration.databaseName();
	}
}
