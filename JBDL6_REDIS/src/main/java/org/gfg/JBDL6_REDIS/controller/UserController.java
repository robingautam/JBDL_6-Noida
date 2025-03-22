package org.gfg.JBDL6_REDIS.controller;

import org.gfg.JBDL6_REDIS.Model.User;
import org.gfg.JBDL6_REDIS.client.RedisClient;
import org.gfg.JBDL6_REDIS.repository.UserRepository;
import org.gfg.JBDL6_REDIS.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisClient redisClient;

    @PostMapping("/users/create/user")
    public User createUser (@RequestBody UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
       return userRepository.save(user);
    }


    @GetMapping("/users/get/user/{id}")
    public User getUserData(@PathVariable String id){
        User user = redisClient.getRedis(id);
        if (user!=null){
            System.out.println("data Found in redis, returning the user");
            return user;
        }

        User dbUser = userRepository.findById(Integer.parseInt(id)).get();
        redisClient.setUserData(Integer.toString(dbUser.getId()),dbUser);
        return dbUser;
    }
}
