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
     BankAccount bankaAccount = bankAccountRepository
     .findByIdForUpdate(accountId)
     .orElseThrow();

    
   }


}
