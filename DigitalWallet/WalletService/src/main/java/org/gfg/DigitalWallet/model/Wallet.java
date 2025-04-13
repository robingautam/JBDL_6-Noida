package org.gfg.DigitalWallet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.common.enums.UserIdentifier;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "wallet")
@Builder
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String userId;

    public String phoneNo;

    @Enumerated(EnumType.STRING)
    public UserIdentifier userIdentifier;

    public String userIdentifierValue;

    double balance;

    @CreationTimestamp
    Date createdOn;

    @UpdateTimestamp
    Date updatedOn;




}
