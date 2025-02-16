package org.example.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DepartmentTechImpl implements Department{
    @Override
    public void getDepartment() {
        System.out.println("Inside the Tech Department");
    }
}
