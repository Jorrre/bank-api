package com.jorre.bankapi.repositories;

import com.jorre.bankapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
