package com.fullstackjava.sql_database.db_locking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstackjava.sql_database.db_locking.entity.BankAccount;
import com.fullstackjava.sql_database.db_locking.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;

/**
 * Service class responsible for managing bank account operations.
 *
 * Demonstrates pessimistic locking using JPA to prevent concurrent
 * transactions from causing inconsistent account balances.
 *
 * Includes withdrawal validation and transaction management.
 */
@Service
@RequiredArgsConstructor
public class BankAccountService {

   private final BankAccountRepository bankAccountRepository;

   /*@Transactional keeps the read, validation, and update within one transaction. */
   @Transactional 
   public void withdraw(Long accountId, BigDecimal amount){
     BankAccount bankAccount = bankAccountRepository
     .findByIdForUpdate(accountId)
     .orElseThrow(() ->
                        new RuntimeException("Account not found"));
     
     if (bankAccount.getBalance().compareTo(amount) < 0) {
      throw new RuntimeException("Insufficient balance");
     }

    bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
     bankAccountRepository.save(bankAccount);
    
   }


}
