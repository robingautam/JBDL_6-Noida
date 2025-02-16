package org.example.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DepartmentHrImpl implements Department{
    @Override
    public void getDepartment() {
        System.out.println("inside the HR Department");
    }
}
