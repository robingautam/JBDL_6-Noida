package org.gfg.DigitalWallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.common.enums.TxnStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    String transactionType;
    double amount;
    String thirdParty;
    Date time;
    TxnStatus txnStatus;

}
