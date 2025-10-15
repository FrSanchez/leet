package com.splabs.meta.banking;

// File: src/test/java/com/splabs/meta/banking/BankingSystemImplTest.java

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Level2Test {
    @Test
    void topActivityReturnsAccountsSortedByActivityDescending() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 100);
        system.deposit(4, "accB", 200);
        system.pay(5, "accB", 50);
        List<String> result = system.topActivity(6, 2);
        assertEquals(List.of("accB(250)", "accA(100)"), result);
    }

    @Test
    void topActivityReturnsEmptyListWhenNoAccounts() {
        BankingSystemImpl system = new BankingSystemImpl();
        List<String> result = system.topActivity(1, 3);
        assertTrue(result.isEmpty());
    }

    @Test
    void topActivityReturnsAllAccountsIfNExceedsAccountCount() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.deposit(2, "accA", 50);
        List<String> result = system.topActivity(3, 5);
        assertEquals(List.of("accA(50)"), result);
    }

    @Test
    void topActivitySortsByAccountIdIfActivityIsEqual() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 100);
        system.deposit(4, "accB", 100);
        List<String> result = system.topActivity(5, 2);
        assertEquals(List.of("accA(100)", "accB(100)"), result);
    }

}