package org.gfg.JBDL6_DigitalLibrary.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    int id;
    String authorName;
    String authorEmail;
    String phoneNo;
    List<Book> bookList;
}
