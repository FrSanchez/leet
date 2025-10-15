package com.splabs.meta.banking;

public class Transfer {
    private int timestamp;
    private String source;
    private String target;
    private int amount;

    public Transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
        this.timestamp = timestamp;
        this.source = sourceAccountId;
        this.target = targetAccountId;
        this.amount = amount;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isValid(int timestamp) {
        return this.timestamp + 86400 >= timestamp;
    }
}
