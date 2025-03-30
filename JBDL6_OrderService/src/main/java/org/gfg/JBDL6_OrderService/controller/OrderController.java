package org.gfg.JBDL6_OrderService.controller;


import org.gfg.JBDL6_OrderService.model.Order;
import org.gfg.JBDL6_OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {


    @Autowired
    OrderService orderService;

    @GetMapping("/get/orders/{userId}")
    public List<Order> getOrderList(@PathVariable("userId") String userId){
        System.out.println("Getting request for order");
        return orderService.getOrderByUserId(Integer.parseInt(userId));

    }
}
