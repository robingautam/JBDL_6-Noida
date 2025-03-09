package org.gfg.JBDL6_DigitalLibrary.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    int id;
    int studentId;
    String name;
    String email;
    String phoneNo;
    List<Book> books;
    Address address;
    StudentType studentType;

}
