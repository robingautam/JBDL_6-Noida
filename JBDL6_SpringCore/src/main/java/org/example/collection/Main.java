package org.example.collection;

import org.example.collection.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/org/example/collection/config.xml");

        Student student = (Student) applicationContext.getBean("aliasstudent");

        System.out.println(student);


    }
}
