package org.gfg.JBDL6_REDIS.controller;

import org.gfg.JBDL6_REDIS.Model.RedisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {


    @Autowired
    RedisTemplate<String,String> redisTemplate;


    @PostMapping("/redis/set")
    public String setDataInRedis(@RequestBody RedisData redisData){
        redisTemplate.opsForValue().set(redisData.getKey(),redisData.getValue());
        return "OK";
    }

    @GetMapping("/redis/get/{key}")
    public String getDataFromRedis(@PathVariable String key){
        return redisTemplate.opsForValue().get(key);
    }
}
