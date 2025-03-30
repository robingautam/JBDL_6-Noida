package org.gfg.JBDL6_OrderService.service;

import org.gfg.JBDL6_OrderService.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    static List<Order> orderList ;

    static {
        Order order1 = new Order(1,1,"1001","IPhone","This is IPhone",55000,new Date());
        Order order2 = new Order(1,2,"1002","Macbook Air","This is Macbook Air",10000,new Date());
        Order order3 = new Order(1,3,"1003","Realme","This is Realme Mobile",25000,new Date());
        Order order4 = new Order(2,4,"1004","IPad","This is IPad",55000,new Date());

        orderList = Arrays.asList(order1,order2,order3,order4);
    }


    public List<Order> getOrderByUserId(int id){

        List<Order> orders = new ArrayList<>();

        for (Order o: orderList){
            if (o.getUserId()==id){
                orders.add(o);
            }
        }

        return orders;
    }
}
