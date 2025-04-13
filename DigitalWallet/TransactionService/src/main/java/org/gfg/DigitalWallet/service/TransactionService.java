package org.gfg.DigitalWallet.service;

import org.gfg.DigitalWallet.model.Transaction;
import org.gfg.DigitalWallet.repository.TransactionRepository;
import org.gfg.common.CommonConstants;
import org.gfg.common.enums.TxnStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;


    public String initiateTransaction(String senderId,String receiverId,String amount,String purpose){

        Transaction transaction = new Transaction();
        transaction.setAmount(Double.parseDouble(amount));
        transaction.setSenderId(senderId);
        transaction.setReceiverId(receiverId);
        transaction.setPurpose(purpose);
        transaction.setTxnMessage("Transaction Initiated");
        transaction.setTxnStatus(TxnStatus.INITIATED);
        transaction.setTxnId(UUID.randomUUID().toString());
        transactionRepository.save(transaction);

        // send data to kafka

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CommonConstants.SENDER_ID,senderId);
        jsonObject.put(CommonConstants.RECEIVER_ID,receiverId);
        jsonObject.put(CommonConstants.TXN_AMOUNT,amount);
        jsonObject.put(CommonConstants.PURPOSE,purpose);
        jsonObject.put(CommonConstants.TRANSACTION_ID,transaction.getTxnId());

        kafkaTemplate.send(CommonConstants.TRANSACTION_DETAILS,jsonObject.toString());

        System.out.println("Transaction data sent to kafka");

        return transaction.getTxnId();
    }
}
