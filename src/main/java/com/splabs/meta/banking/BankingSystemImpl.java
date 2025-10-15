package com.splabs.meta.banking;

import java.util.Optional;
import java.util.*;

class BankingSystemImpl implements BankingSystem {
    Map<String, Account> accounts;
    Map<String, Integer> log;
    Map<String, Transfer> transfers;
    int transferCount = 0;

    private void logTransaction(String accountId, int value) {
        if (!log.containsKey(accountId)) {
            log.put(accountId, value);
        } else {
            log.computeIfPresent(accountId, (k,v) -> v+value);
        }
    }

    public BankingSystemImpl() {
        accounts = new HashMap<>();
        log = new HashMap<>();
        transfers = new HashMap<>();
    }

    @Override
    public boolean createAccount(int timestamp, String accountId) {
        if (accounts.containsKey(accountId)) {
            return false;
        }
        logTransaction(accountId, 0);
        accounts.put(accountId, new Account(accountId));
        return true;
    }

    @Override
    public Optional<Integer> deposit(int timestamp, String accountId, int amount) {
        if (accounts.containsKey(accountId) && amount >= 0) {
            logTransaction(accountId, amount);
            int output = accounts.get(accountId).updateBalance(amount);
            return Optional.of(output);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> pay(int timestamp, String accountId, int amount) {
        var account = accounts.get(accountId);
        if (null != account && account.getBalance() >= amount) {
            int output = account.updateBalance(-amount);
            logTransaction(accountId, amount);
            return Optional.of(output);
        }
        return Optional.empty();
    }

    @Override
    public List<String> topActivity(int timestamp, int n) {
        // default implementation
        var answer = new ArrayList<String>();

        var entries = new ArrayList<Map.Entry<String, Integer>>(log.entrySet());
        entries.sort((e1, e2) -> {
            int comp = Integer.compare(e2.getValue(), e1.getValue());
            if (comp != 0) {
                return comp;
            }
            return e1.getKey().compareTo(e2.getKey());
        });
        int num = Math.min(n, entries.size());
        for(int i = 0; i < num; i++) {
            var entry = entries.get(i);
            String result = String.format("%s(%d)", entry.getKey(), entry.getValue());
            answer.add(result);
        }
        return answer;
    }

    @Override
    public Optional<String> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
        if (sourceAccountId != targetAccountId && (accounts.containsKey(sourceAccountId) && accounts.containsKey(targetAccountId)) && accounts.get(sourceAccountId).getBalance() >= amount) {
            var txId = String.format("transfer%d",++transferCount);
            accounts.get(sourceAccountId).updateBalance(-amount);
            transfers.put(txId, new Transfer(timestamp, sourceAccountId, targetAccountId, amount));
            return Optional.of(txId);
        }
        // default implementation
        return Optional.empty();
    }

    @Override
    public boolean acceptTransfer(int timestamp, String accountId, String transferId) {
        Transfer transfer = transfers.get(transferId);
        System.out.println(accountId + " " + transferId);
        if (transfer != null && transfer.getTarget().equalsIgnoreCase(accountId)) {
            System.out.println(transfer);
            if (transfer.isValid(timestamp)) {
                // accept transfer
                logTransaction(transfer.getSource(), transfer.getAmount());
                logTransaction(transfer.getTarget(), transfer.getAmount());
                accounts.get(accountId).updateBalance(transfer.getAmount());
                return true;
            } else {
                System.out.println("Expired");
                accounts.get(transfer.getSource()).updateBalance(transfer.getAmount());
            }
        }
        System.out.println("false");
        return false;
    }
}

