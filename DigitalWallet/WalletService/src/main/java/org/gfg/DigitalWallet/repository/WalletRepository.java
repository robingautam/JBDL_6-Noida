package org.gfg.DigitalWallet.repository;

import org.gfg.DigitalWallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {

    Wallet findByPhoneNo(String phone);

    @Modifying
    @Transactional
    @Query("update wallet w set w.balance=w.balance+:amount where w.phoneNo=:sender")
    void updateWallet(String sender, double amount);

}
