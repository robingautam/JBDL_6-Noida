package org.gfg.DigitalWallet.service;

import org.gfg.DigitalWallet.model.User;
import org.gfg.DigitalWallet.model.enums.UserStatus;
import org.gfg.DigitalWallet.repository.UserRepository;
import org.gfg.DigitalWallet.request.UserCreationRequest;
import org.gfg.common.CommonConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;


    public User createNewUser(UserCreationRequest userCreationRequest){
        User user = userCreationRequest.toUser();
        user.setUserStatus(UserStatus.ACTIVE);
        user.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));

        User dbUser = userRepository.save(user);

        // now push data into kafka
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(CommonConstants.USER_ID, dbUser.getId());
            jsonObject.put(CommonConstants.USER_NAME, dbUser.getName());
            jsonObject.put(CommonConstants.USER_EMAIL, dbUser.getEmail());
            jsonObject.put(CommonConstants.USER_MOBILE, dbUser.getPhoneNo());
            jsonObject.put(CommonConstants.USER_IDENTIFIER, dbUser.getUserIdentifier());
            jsonObject.put(CommonConstants.USER_IDENTIFIER_VALUE, dbUser.getUserIdentifierValue());

            String data = jsonObject.toString();

            kafkaTemplate.send(CommonConstants.USER_CREATION_TOPIC, data);

            System.out.println("Data Sent to Kafka");
        } catch (Exception exception) {
            System.out.println("Some Issue in sending data to kafka: "+exception);
        }

        return dbUser;
    }


    public String validateUser(String phone){
        User user = userRepository.findByphoneNo(phone);
        if (user==null){
            return null;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CommonConstants.USER_MOBILE,user.getPhoneNo());
        jsonObject.put(CommonConstants.USER_PASSWORD,user.getPassword());

        return jsonObject.toString();
    }
}
