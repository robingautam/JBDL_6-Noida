package org.example.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import org.example.models.Person;

public class JPAApp {

    public static void main(String[] args) {

        Person person = new Person(1,"Robin","robin@gmail.com");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        System.out.println("data saved");
    }
}
