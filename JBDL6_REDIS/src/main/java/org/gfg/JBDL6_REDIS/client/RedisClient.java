package org.gfg.JBDL6_REDIS.client;

import org.gfg.JBDL6_REDIS.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {


    @Autowired
    RedisTemplate<String,User> redisTemplate;

    public User getRedis(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void setUserData(String key, User user){
        redisTemplate.opsForValue().set(key,user);
    }
}
