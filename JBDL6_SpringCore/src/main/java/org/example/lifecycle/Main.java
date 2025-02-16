package org.example.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("/org/example/lifecycle/lifecycleconfig.xml");

         DatabaseModel databaseModel = applicationContext.getBean("dbmodel", DatabaseModel.class);
         DatabaseModel databaseModel1 = applicationContext.getBean("dbmodel", DatabaseModel.class);
         //applicationContext.registerShutdownHook();

        System.out.println(databaseModel.hashCode());
        System.out.println(databaseModel1.hashCode());

    }
}
