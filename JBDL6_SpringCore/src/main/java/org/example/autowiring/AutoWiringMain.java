package org.example.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/org/example/autowiring/autowireconfig.xml");

       Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);
    }
}
