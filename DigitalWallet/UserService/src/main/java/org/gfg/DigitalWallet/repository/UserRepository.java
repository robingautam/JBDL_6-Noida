package org.gfg.DigitalWallet.repository;


import org.gfg.DigitalWallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByphoneNo(String phoneNumber);
}
