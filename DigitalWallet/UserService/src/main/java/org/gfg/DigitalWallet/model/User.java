package org.gfg.DigitalWallet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.DigitalWallet.model.enums.UserStatus;
import org.gfg.common.enums.UserIdentifier;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String password;
    String address;

    @Column(unique = true)
    String email;

    @Column(unique = true, length = 13)
    String phoneNo;

    @Enumerated(value = EnumType.STRING)
    UserIdentifier userIdentifier;

    String userIdentifierValue;

    @Enumerated(value = EnumType.STRING)
    UserStatus userStatus;

    String dob;

    @CreationTimestamp
    Date createdOn;

    @UpdateTimestamp
    Date updatedOn;
}
