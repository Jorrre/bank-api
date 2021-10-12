package com.jorre.bankapi.repositories;

import com.jorre.bankapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JPA repository related to Accounts
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    /**
     * Query for fetching an Account based on the accounts name. The name has a
     * unique constraint guaranteeing an unambiguous response.
     *
     * @param name name of account.
     * @return Optional containing the account with the given name if it exists
     */
    Optional<Account> findByName(String name);

}
