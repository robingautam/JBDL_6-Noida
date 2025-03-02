package org.example;


import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {

        Person person = new Person( 5,"Robin","robin@gmail.com");
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(person);
      //  session.delete(Person.class);
        transaction.commit();
    //  Person retrnPerson =  session.get(Person.class,1);
      //  System.out.println(retrnPerson);
        System.out.println("data saved");
    }
}
