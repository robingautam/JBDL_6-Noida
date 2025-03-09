package org.gfg.JBDL6_DigitalLibrary.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.gfg.JBDL6_DigitalLibrary.models.Address;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreationRequest {

    String studentId;
    String name;
    String email;
    String phoneNo;
    Address address;
}
