package org.gfg.JBDL6_UserService.model;

import java.util.List;

public class User {
    int id;
    String name;
    String email;
    String address;

    List<Order> orderList;

    User(){}

    public User(int id, String name, String email, String address, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.orderList = orderList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
