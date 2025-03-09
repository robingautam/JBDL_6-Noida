package org.gfg.JBDL6_DigitalLibrary.models;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    int id;
    Student student;
    Book book;
    double paidAmount;
    Timestamp createdOn;
    Timestamp updatedOn;
    TransactionType type;
}
