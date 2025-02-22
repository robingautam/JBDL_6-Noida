package org.gfg.JBDL6_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

//@SpringBootApplication(exclude = {DispatcherServletAutoConfiguration.class, ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class Jbdl6SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jbdl6SpringBootApplication.class, args);
	}

}
