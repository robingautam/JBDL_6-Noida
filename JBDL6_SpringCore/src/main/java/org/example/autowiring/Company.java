package org.example.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company1234")
public class Company {
    @Value("Atliassian")
    String name;
    @Value("tools")
    String function;
    @Value("banglore")
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", function='" + function + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
