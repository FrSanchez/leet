package com.splabs.meta.banking;

// File: src/test/java/com/splabs/meta/banking/BankingSystemImplTest.java

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Level1Test {

    @Test
    void testCreateAccountSuccess() {
        BankingSystemImpl system = new BankingSystemImpl();
        boolean result = system.createAccount(1, "acc1");
        assertTrue(result);
    }

    @Test
    void testCreateAccountDuplicate() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "acc1");
        boolean result = system.createAccount(2, "acc1");
        assertFalse(result);
    }

    @Test
    void testDepositSuccess() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "acc1");
        Optional<Integer> result = system.deposit(2, "acc1", 100);
        assertTrue(result.isPresent());
        assertEquals(100, result.get());
    }

    @Test
    void testDepositNegativeAmount() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "acc1");
        Optional<Integer> result = system.deposit(2, "acc1", -50);
        assertTrue(result.isEmpty());
    }

    @Test
    void testDepositNonExistentAccount() {
        BankingSystemImpl system = new BankingSystemImpl();
        Optional<Integer> result = system.deposit(2, "acc2", 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testPaySuccess() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "acc1");
        system.deposit(2, "acc1", 200);
        Optional<Integer> result = system.pay(3, "acc1", 150);
        assertTrue(result.isPresent());
        assertEquals(50, result.get());
    }

    @Test
    void testPayInsufficientFunds() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "acc1");
        system.deposit(2, "acc1", 100);
        Optional<Integer> result = system.pay(3, "acc1", 150);
        assertTrue(result.isEmpty());
    }

    @Test
    void testPayNonExistentAccount() {
        BankingSystemImpl system = new BankingSystemImpl();
        Optional<Integer> result = system.pay(3, "acc2", 50);
        assertTrue(result.isEmpty());
    }
}
