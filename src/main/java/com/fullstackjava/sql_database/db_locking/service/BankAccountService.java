package com.fullstackjava.sql_database.db_locking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstackjava.sql_database.db_locking.entity.BankAccount;
import com.fullstackjava.sql_database.db_locking.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankAccountService {
   private final BankAccountRepository bankAccountRepository;

   @Transactional 
   public void withdraw(Long accountId, BigDecimal amount){
     BankAccount bankAccount = bankAccountRepository
     .findByIdForUpdate(accountId)
     .orElseThrow();
     
     if(bankAccount.getBalance().compareTo(amount)<0){
      throw new IllegalArgumentException("Insufficient Balance");
     }

     bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
    System.out.println("HEllo");
   }


}
