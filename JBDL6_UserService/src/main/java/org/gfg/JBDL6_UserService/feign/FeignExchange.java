package org.gfg.JBDL6_UserService.feign;

import org.gfg.JBDL6_UserService.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "http://localhost:8090")
public interface FeignExchange {


    @GetMapping("/order-service/get/orders/{userId}")
    public List<Order> getOrderList(@PathVariable("userId") String userId);

}
