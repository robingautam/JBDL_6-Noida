package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbctemplate", JdbcTemplate.class);


       int row = jdbcTemplate.update("insert into student (id,name,email) values (?,?,?)",1,"Robin","robin@gmail.com");

        System.out.println("Rows updated: "+row);

    }
}
