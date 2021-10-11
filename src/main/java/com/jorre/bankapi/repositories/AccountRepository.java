package com.jorre.bankapi.repositories;

import com.jorre.bankapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByName(String name);

}
