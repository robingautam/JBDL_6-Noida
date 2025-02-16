package org.example.standalone;

import org.example.collection.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandAloneMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/org/example/standalone/standaloneconfig.xml");
        StandCollection standCollection = (StandCollection)applicationContext.getBean("scol");


        System.out.println(standCollection);
    }
}
