package org.gfg.DigitalWallet.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.DigitalWallet.model.User;
import org.gfg.common.enums.UserIdentifier;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {

    @NotBlank
    String name;
    @NotBlank
    String email;
    @NotBlank
    String phoneNo;
    @NotBlank
    String password;
    @NotBlank
    UserIdentifier userIdentifier;
    @NotBlank
    String userIdentifierValue;
    @NotBlank
    String address;
    @NotBlank
    String dob;

    public User toUser() {
        User user = User.builder().name(this.name).email(this.email).phoneNo(this.phoneNo)
                .password(this.password).userIdentifier(this.userIdentifier)
                .userIdentifierValue(this.userIdentifierValue).address(this.address).dob(this.dob).build();

        return user;
    }
}
