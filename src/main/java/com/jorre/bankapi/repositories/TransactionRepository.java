package com.jorre.bankapi.repositories;

import com.jorre.bankapi.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository related to transactions.
 */
public interface TransactionRepository extends JpaRepository<Transaction,
        Long> {

}
