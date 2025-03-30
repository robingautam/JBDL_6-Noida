package org.gfg.JBDL6_UserService.controller;



import org.gfg.JBDL6_UserService.model.User;
import org.gfg.JBDL6_UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/user/{userId}")
    public User getUserInfo(@PathVariable("userId") String userId){
        return userService.getUserById(Integer.parseInt(userId));
    }
}
