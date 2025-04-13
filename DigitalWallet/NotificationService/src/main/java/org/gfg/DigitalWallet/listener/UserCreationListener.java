package org.gfg.DigitalWallet.listener;

import org.gfg.DigitalWallet.worker.EmailWorker;
import org.gfg.common.CommonConstants;
import org.gfg.common.enums.UserIdentifier;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserCreationListener {

    @Autowired
    EmailWorker emailWorker;

    @KafkaListener(topics = "USER_CREATION_TOPIC", groupId = "email-group")
    public void listenUserData(String data){
        JSONObject jsonObject = new JSONObject(data);
        String userName = jsonObject.getString(CommonConstants.USER_NAME);
        String userEmail = jsonObject.getString(CommonConstants.USER_EMAIL);
        UserIdentifier userIdentifier = jsonObject.getEnum(UserIdentifier.class,CommonConstants.USER_IDENTIFIER);
        String userIdentifierValue = jsonObject.getString(CommonConstants.USER_IDENTIFIER_VALUE);

        emailWorker.sendEmailToUser(userName,userEmail,userIdentifier,userIdentifierValue);
    }
}
