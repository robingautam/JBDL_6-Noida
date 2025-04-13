package org.gfg.DigitalWallet.service;

import jakarta.transaction.Transactional;
import org.gfg.DigitalWallet.model.Wallet;
import org.gfg.DigitalWallet.repository.WalletRepository;
import org.gfg.common.CommonConstants;
import org.gfg.common.enums.TxnStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;


    public void createWalletAccount(Wallet wallet){
        walletRepository.save(wallet);
        System.out.println("wallet account has been created successfully");
    }

    String txnMessage = "";
    TxnStatus txnStatus;


    public void updateTransaction(String sender,String receiver,String amount,String txnId){
        boolean isProcessed = false;
        Wallet senderWallet = walletRepository.findByPhoneNo(sender);
        Wallet receiverWallet = walletRepository.findByPhoneNo(receiver);


        if (senderWallet==null){
            txnMessage = "sender wallet doesn't exist";
            txnStatus = TxnStatus.FAILED;
        }
        else if (receiverWallet==null){
            txnMessage = "receiver wallet doesn't exist";
            txnStatus = TxnStatus.FAILED;
        }
        else {
            double amountToBeTransfer = Double.parseDouble(amount);
            double currentBalance = senderWallet.getBalance();
            if (amountToBeTransfer>currentBalance){
                txnMessage = "Insufficient Balance";
                txnStatus = TxnStatus.FAILED;
            }else {
              isProcessed  = processTransaction(sender,receiver,amountToBeTransfer);
                if (isProcessed){
                    txnMessage = "Transaction is successfull";
                    txnStatus = TxnStatus.SUCCESS;
                }else {
                    txnMessage = "Transaction is Pending";
                    txnStatus = TxnStatus.PENDING;
                }
            }
        }


        // send the updated details to kafka

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CommonConstants.TRANSACTION_ID,txnId);
        jsonObject.put(CommonConstants.TRANSACTION_MESSAGE,txnMessage);
        jsonObject.put(CommonConstants.TRANSACTION_STATUS,txnStatus);

        kafkaTemplate.send(CommonConstants.UPDATED_TRANSACTION_DETAILS,jsonObject.toString());

        System.out.println("Update transaction details sent to kafka");

    }

    @Transactional
    public boolean processTransaction(String senderId, String receiverId,double amount){
        boolean isProcessed = true;
        try {
            walletRepository.updateWallet(senderId, -amount);
            walletRepository.updateWallet(receiverId, amount);
        }
        catch (Exception exception){
            isProcessed = false;
        }
        return isProcessed;
    }
}
