package org.gfg.DigitalWallet.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationResponse extends Response {

    String name;
    String email;
    String phoneNo;
    String address;
}
