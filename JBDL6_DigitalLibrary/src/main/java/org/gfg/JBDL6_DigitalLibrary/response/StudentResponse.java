package org.gfg.JBDL6_DigitalLibrary.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse extends Response{
    String studentId;
    String name;

}
