package org.example.config;

import org.example.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.model")
public class JavaConfig {

    @Bean(name = {"student","robin"})
    public Student getStudent(){
        Student student = new Student();
        student.setId(1);
        student.setName("Robin");
        student.setEmail("robin@gmail.com");
        return student;
    }


}
