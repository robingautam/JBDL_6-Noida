package org.example;

import org.example.model.Addition;
import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
      /*  Person person = (Person) applicationContext.getBean("person");


        System.out.println(person);

        Person person2 = (Person) applicationContext.getBean("person2");
        System.out.println(person2);*/

        Addition addition = (Addition) applicationContext.getBean("addition");
        System.out.println(addition);
    }
}
