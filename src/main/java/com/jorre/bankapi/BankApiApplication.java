package com.jorre.bankapi;

import com.jorre.bankapi.models.Account;
import com.jorre.bankapi.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApiApplication.class, args);
    }

    /**
     * Adds two sample accounts to the db upon starting the application.
     * @param accountRepository JPA repository to save samples to db
     * @return the command to be run
     */
    @Bean
    CommandLineRunner addSampleAccounts(AccountRepository accountRepository) {
        return args -> {
            Account acc1 = new Account("Account 1", 123.4);
            Account acc2 = new Account("Account 2", 432.1);
            accountRepository.save(acc1);
            accountRepository.save(acc2);
        };
    }
}
