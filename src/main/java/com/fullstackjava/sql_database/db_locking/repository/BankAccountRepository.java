package com.fullstackjava.sql_database.db_locking.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstackjava.sql_database.db_locking.entity.BankAccount;

import jakarta.persistence.LockModeType;

public interface BankAccountRepository
        extends JpaRepository<BankAccount, Long> {
                
/*PESSIMISTIC_WRITE typically translates to a database row lock, 
       such as SELECT ... FOR UPDATE in PostgreSQL.*/

                @Lock(LockModeType.PESSIMISTIC_WRITE)
                @Query ("SELECT a FROM BankAccount a WHERE a.id = :id")
                Optional<BankAccount> findByIdForUpdate(@Param("id") Long id);


}