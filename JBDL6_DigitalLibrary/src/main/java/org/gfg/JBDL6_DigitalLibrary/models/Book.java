package org.gfg.JBDL6_DigitalLibrary.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    int id;
    String name;
    String title;
    double price;
    String serialNo;
    Author author;
    BookType bookType;

    String publisher;
}
