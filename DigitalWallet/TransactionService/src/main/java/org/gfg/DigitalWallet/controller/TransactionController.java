package org.gfg.DigitalWallet.controller;

import org.gfg.DigitalWallet.model.Transaction;
import org.gfg.DigitalWallet.model.TransactionHistory;
import org.gfg.DigitalWallet.repository.TransactionRepository;
import org.gfg.DigitalWallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/txn-service")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/initiate/transaction")
    public String initiateTransaction(@RequestParam("receiverId") String receiver,
                                      @RequestParam("amount") String amount,
                                      @RequestParam("purpose") String purpose){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return transactionService.initiateTransaction(user.getUsername(),receiver,amount,purpose);

    }


    @GetMapping("/get/transactions/history")
    public List<TransactionHistory> transactionHistory(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Transaction> transactionList = transactionRepository.findBySenderIdOrReceiverId(user.getUsername(), user.getUsername());

        List<TransactionHistory> ans = new ArrayList<>();

        for (Transaction tr: transactionList){
            TransactionHistory th = new TransactionHistory();
            th.setAmount(tr.getAmount());
            th.setTime(tr.getUpdatedOn());
            th.setTxnStatus(tr.getTxnStatus());
            if (tr.getSenderId().equals(user.getUsername())){
                th.setThirdParty(tr.getReceiverId());
                th.setTransactionType("DEBIT");
            }else {
                th.setThirdParty(tr.getSenderId());
                th.setTransactionType("CREDIT");
            }
            ans.add(th);
        }

        return ans;

    }
}
