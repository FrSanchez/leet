package com.splabs.meta.banking;

// File: src/test/java/com/splabs/meta/banking/BankingSystemImplTest.java

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class Level3Test {
    @Test
    void transferSucceedsWithValidAccountsAndSufficientFunds() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 100);
        Optional<String> transferId = system.transfer(4, "accA", "accB", 50);
        assertTrue(transferId.isPresent());
    }

    @Test
    void transferFailsWhenSourceAndTargetAreSame() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.deposit(2, "accA", 100);
        Optional<String> transferId = system.transfer(3, "accA", "accA", 50);
        assertTrue(transferId.isEmpty());
    }

    @Test
    void transferFailsWithInsufficientFunds() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 30);
        Optional<String> transferId = system.transfer(4, "accA", "accB", 50);
        assertTrue(transferId.isEmpty());
    }

    @Test
    void transferFailsWithNonExistentSourceAccount() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accB");
        Optional<String> transferId = system.transfer(2, "accA", "accB", 10);
        assertTrue(transferId.isEmpty());
    }

    @Test
    void transferFailsWithNonExistentTargetAccount() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.deposit(2, "accA", 100);
        Optional<String> transferId = system.transfer(3, "accA", "accB", 10);
        assertTrue(transferId.isEmpty());
    }

    @Test
    void acceptTransferSucceedsForValidTransferAndTargetAccount() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 100);
        Optional<String> transferId = system.transfer(4, "accA", "accB", 50);
        boolean accepted = system.acceptTransfer(5, "accB", transferId.get());
        assertTrue(accepted);
    }

    @Test
    void acceptTransferFailsForInvalidTransferId() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        boolean accepted = system.acceptTransfer(2, "accA", "invalidId");
        assertFalse(accepted);
    }

    @Test
    void acceptTransferFailsForNonTargetAccount() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 100);
        Optional<String> transferId = system.transfer(4, "accA", "accB", 50);
        boolean accepted = system.acceptTransfer(5, "accA", transferId.get());
        assertFalse(accepted);
    }

    @Test
    void acceptTransferFailsForExpiredTransfer() {
        BankingSystemImpl system = new BankingSystemImpl();
        system.createAccount(1, "accA");
        system.createAccount(2, "accB");
        system.deposit(3, "accA", 100);
        Optional<String> transferId = system.transfer(4, "accA", "accB", 50);
        boolean accepted = system.acceptTransfer(1000, "accB", transferId.get());
        assertFalse(accepted);
    }

}
