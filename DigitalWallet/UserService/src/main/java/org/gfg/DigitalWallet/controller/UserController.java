package org.gfg.DigitalWallet.controller;

import org.gfg.DigitalWallet.model.User;
import org.gfg.DigitalWallet.request.UserCreationRequest;
import org.gfg.DigitalWallet.response.Response;
import org.gfg.DigitalWallet.response.UserCreationResponse;
import org.gfg.DigitalWallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onboarding-service")
public class UserController {


    @Autowired
    UserService userService;


    @PostMapping("/onboard/user/new")
    public ResponseEntity<UserCreationResponse> onboardUser(@RequestBody UserCreationRequest userCreationRequest){
        // code
        if (userCreationRequest==null){
            UserCreationResponse response = new UserCreationResponse();
            response.setMessage("Request shouldn't be blank");
            response.setCode("110");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(userCreationRequest.getEmail()) || StringUtils.isEmpty(userCreationRequest.getName()) || StringUtils.isEmpty(userCreationRequest.getAddress())
            || StringUtils.isEmpty(userCreationRequest.getUserIdentifierValue()) || StringUtils.isEmpty(userCreationRequest.getPassword())
            || StringUtils.isEmpty(userCreationRequest.getAddress())){

            UserCreationResponse response = new UserCreationResponse();
            response.setMessage("Request shouldn't be blank");
            response.setCode("110");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        User user = userService.createNewUser(userCreationRequest);
        UserCreationResponse userCreationResponse = new UserCreationResponse();
        if (user==null){
            userCreationResponse.setCode("01");
            userCreationResponse.setMessage("User not Onboarded");
            return new ResponseEntity<>(userCreationResponse,HttpStatus.OK);
        }

        userCreationResponse.setCode("00");
        userCreationResponse.setMessage("User Onboarded Successfully");
        userCreationResponse.setName(user.getName());
        userCreationResponse.setEmail(user.getEmail());
        userCreationResponse.setAddress(user.getAddress());
        userCreationResponse.setPhoneNo(user.getPhoneNo());

        return new ResponseEntity<>(userCreationResponse,HttpStatus.CREATED);
    }

    @GetMapping("/validate/user/{userId}")
    public String validateUser(@PathVariable("userId") String userId){
        return userService.validateUser(userId);
    }
}
