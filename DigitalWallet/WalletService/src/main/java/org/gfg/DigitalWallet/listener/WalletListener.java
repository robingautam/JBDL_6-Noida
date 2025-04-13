package org.gfg.DigitalWallet.listener;

import org.gfg.DigitalWallet.model.Wallet;
import org.gfg.DigitalWallet.service.WalletService;
import org.gfg.common.CommonConstants;
import org.gfg.common.enums.UserIdentifier;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletListener {

    @Value("${wallet.initial.amount}")
    private String walletBalance;

    @Autowired
    WalletService walletService;


    @KafkaListener(topics = "USER_CREATION_TOPIC", groupId = "wallet-group")
    public void listenNewlyCreatedUser(String data){
        JSONObject jsonObject = new JSONObject(data);
        String userName = jsonObject.getString(CommonConstants.USER_NAME);
        String userEmail = jsonObject.getString(CommonConstants.USER_EMAIL);
        UserIdentifier userIdentifier = jsonObject.getEnum(UserIdentifier.class,CommonConstants.USER_IDENTIFIER);
        String userIdentifierValue = jsonObject.getString(CommonConstants.USER_IDENTIFIER_VALUE);
        String userId = Integer.toString(jsonObject.getInt(CommonConstants.USER_ID));
        String userMobile = jsonObject.getString(CommonConstants.USER_MOBILE);

        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        wallet.setBalance(Double.parseDouble(walletBalance));
        wallet.setUserIdentifier(userIdentifier);
        wallet.setUserIdentifierValue(userIdentifierValue);
        wallet.setPhoneNo(userMobile);

        walletService.createWalletAccount(wallet);
    }

    @KafkaListener(topics = "TRANSACTION_DETAILS", groupId = "transaction-group")
    public void listenNewTransactions(String data){
        JSONObject jsonObject = new JSONObject(data);
        String senderId = jsonObject.getString(CommonConstants.SENDER_ID);
        String receiverId = jsonObject.getString(CommonConstants.RECEIVER_ID);
        String amount = jsonObject.getString(CommonConstants.TXN_AMOUNT);
        String txnId = jsonObject.getString(CommonConstants.TRANSACTION_ID);

        walletService.updateTransaction(senderId,receiverId,amount,txnId);
    }
}
