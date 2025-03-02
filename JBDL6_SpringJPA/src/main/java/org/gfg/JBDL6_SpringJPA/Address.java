package org.gfg.JBDL6_SpringJPA;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    String street;
    String pincode;

    public Address(){}

    public Address(String street, String pincode) {
        this.street = street;
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
