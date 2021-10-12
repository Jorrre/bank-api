package com.jorre.bankapi.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Unit tests for Account
 */
class AccountTest {

    private Account testAccount;

    @BeforeEach
    void setUp() {
        testAccount = new Account("Account 1", 200.2);
    }

    @Test
    void subtractCash_andExpectOk() {
        testAccount.subtractCash(150);
        assertEquals(50.2, testAccount.getAvailableCash());
    }

    @Test
    void subtractCash_andExpectOk_edgeCase() {
        testAccount.subtractCash(200.2);
        assertEquals(0.0, testAccount.getAvailableCash());
    }

    @Test
    void subtractCash_andExpectFail() {
        assertThrows(IllegalStateException.class,
                () -> testAccount.subtractCash(250));
    }


}
