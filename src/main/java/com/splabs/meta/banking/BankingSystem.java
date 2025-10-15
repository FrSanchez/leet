package com.splabs.meta.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * The BankingSystem interface provides methods for managing bank accounts and transactions.
 * It allows for creating accounts, depositing and withdrawing funds, transferring money between accounts,
 * and retrieving the top active accounts.
 */
public interface BankingSystem {

    /**
     * Creates a new bank account with the given account ID at the specified timestamp.
     *
     * @param timestamp   the timestamp at which the account is created
     * @param accountId   the unique ID of the account to be created
     * @return true if the account is created successfully, false otherwise
     */
    default boolean createAccount(int timestamp, String accountId) {
        return false;
    }

    /**
     * Deposits the specified amount into the account with the given ID at the specified timestamp.
     *
     * @param timestamp   the timestamp at which the deposit is made
     * @param accountId   the ID of the account to deposit into
     * @param amount      the amount to be deposited
     * @return an Optional containing the new balance if the deposit is successful, empty otherwise
     */
    default Optional<Integer> deposit(int timestamp, String accountId, int amount) {
        return Optional.empty();
    }

    /**
     * Withdraws the specified amount from the account with the given ID at the specified timestamp.
     *
     * @param timestamp   the timestamp at which the withdrawal is made
     * @param accountId   the ID of the account to withdraw from
     * @param amount      the amount to be withdrawn
     * @return an Optional containing the new balance if the withdrawal is successful, empty otherwise
     */
    default Optional<Integer> pay(int timestamp, String accountId, int amount) {
        return Optional.empty();
    }

    /**
     * Retrieves the top N active accounts.
     *
     * @param timestamp   the timestamp at which to retrieve the top active accounts
     * @param n           the number of top active accounts to retrieve
     * @return a List of the top N active account IDs
     */
    default List<String> topActivity(int timestamp, int n) {
        return new ArrayList<>();
    }

    /**
     * Transfers the specified amount from the source account to the target account at the specified timestamp.
     *
     * @param timestamp       the timestamp at which the transfer is made
     * @param sourceAccountId the ID of the source account
     * @param targetAccountId the ID of the target account
     * @param amount          the amount to be transferred
     * @return an Optional containing the transfer ID if the transfer is successful, empty otherwise
     */
    default Optional<String> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
        return Optional.empty();
    }

    /**
     * Accepts a transfer with the given transfer ID into the account with the specified ID at the specified timestamp.
     *
     * @param timestamp   the timestamp at which the transfer is accepted
     * @param accountId   the ID of the account to accept the transfer into
     * @param transferId  the ID of the transfer to be accepted
     * @return true if the transfer is accepted successfully, false otherwise
     */
    default boolean acceptTransfer(int timestamp, String accountId, String transferId) {
        return false;
    }

    /**
     * Retrieves the transaction log for the account with the specified ID.
     * The transaction log contains a record of all transactions associated with the account.
     *
     * @param accountId the ID of the account for which to retrieve the transaction log
     * @return a List of transaction log entries for the specified account
     */
    default List<String> getTransactionLog(String accountId) {
        return new ArrayList<>();
    }

}
