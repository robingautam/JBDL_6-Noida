package org.example;


import org.example.config.JavaConfig;
import org.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student = applicationContext.getBean("robin", Student.class);
        System.out.println(student);
        student.getDepartment().getDepartment();
    }
}
