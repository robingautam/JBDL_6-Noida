package org.gfg.DigitalWallet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.common.enums.TxnStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "transaction")
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String senderId;
    public String receiverId;
    public String txnId;
    double amount;
    String purpose;

    @Enumerated(EnumType.STRING)
    public TxnStatus txnStatus;

    public String txnMessage;

    @CreationTimestamp
    Date createdOn;

    @UpdateTimestamp
    Date updatedOn;

}
