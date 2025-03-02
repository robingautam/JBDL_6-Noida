package org.example.models;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "person_name")
    String name;
    String email;

    Person(){}

   public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
