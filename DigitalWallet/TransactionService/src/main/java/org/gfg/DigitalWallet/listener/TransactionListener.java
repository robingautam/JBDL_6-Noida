package org.gfg.DigitalWallet.listener;

import org.gfg.DigitalWallet.repository.TransactionRepository;
import org.gfg.common.CommonConstants;
import org.gfg.common.enums.TxnStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionListener {

    @Autowired
    TransactionRepository transactionRepository;


    @KafkaListener(topics = "UPDATED_TRANSACTION_DETAILS",groupId = "updated-transaction")
    public void UpdatedTransactionListener(String data){
        JSONObject jsonObject = new JSONObject(data);

        String txnId = jsonObject.getString(CommonConstants.TRANSACTION_ID);
        String txnMessage = jsonObject.getString(CommonConstants.TRANSACTION_MESSAGE);
        TxnStatus txnStatus = jsonObject.getEnum(TxnStatus.class,CommonConstants.TRANSACTION_STATUS);

        transactionRepository.updateTransactionDetails(txnId,txnStatus,txnMessage);

        System.out.println("Transaction details updated");

    }
}
