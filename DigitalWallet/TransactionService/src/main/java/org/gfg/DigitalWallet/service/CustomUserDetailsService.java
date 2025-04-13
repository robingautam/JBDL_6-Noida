package org.gfg.DigitalWallet.service;

import org.gfg.common.CommonConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Inside the custom user details service");
      String userData =  restTemplate.getForObject("http://localhost:8081/onboarding-service/validate/user/"+username, String.class);
      if (userData==null){
          throw new UsernameNotFoundException("User Not Found");
      }
        System.out.println(userData);
        JSONObject jsonObject = new JSONObject(userData);
        String password = jsonObject.getString(CommonConstants.USER_PASSWORD);

        UserDetails user = User.builder().username(username).password(password).build();
        return user;

    }
}
