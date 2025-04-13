package org.gfg.DigitalWallet.controller;

import org.gfg.DigitalWallet.model.Wallet;
import org.gfg.DigitalWallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet-service")
public class WalletController {

    @Autowired
    WalletRepository walletRepository;

    @GetMapping("/get/balance/{mobile}")
    public String getWalletBalance(@PathVariable("mobile") String mobileNo){
        Wallet wallet = walletRepository.findByPhoneNo(mobileNo);
        if (wallet==null){
            return null;
        }

        return Double.toString(wallet.getBalance());
    }
}
