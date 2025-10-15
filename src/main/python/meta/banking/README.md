Banking System
==============

You're building the foundation of a simple banking system. The system must support account creation, deposits, and payments (withdrawals), with strict validation rules. Your goal is to implement the following interface:
```python
class BankingSystem(ABC):
    def create_account(self, timestamp: int, account_id: str) -> bool:
    def deposit(self, timestamp: int, account_id: str, amount: int)     def pay(self, timestamp: int, account_id: str, amount: int) -> Optional[int]:
```
---
# Stage 1 - The basics
## 🔹Operation 1: `createAccount`
**Purpose:** Create a new account with a unique accountId.

**Rules:**

- Each accountId must be unique.
- If the account does not exist, create it and return true.
- If the account already exists, return false.

## 🔹Operation 2: `deposit`
Purpose: Deposit funds into an existing account.

**Rules:**

- The account must exist.
- The amount must be a positive integer.
- If valid, update the account balance and return Optional.of(newBalance).
- If invalid (nonexistent account or non-positive amount), return Optional.empty().

## 🔹Operation 3: `pay`
Purpose: Withdraw funds from an existing account.

**Rules:**

- The account must exist.
- The amount must be a positive integer.
- The account must have sufficient balance to cover the payment.
- If valid, deduct the amount and return Optional.of(newBalance).
- If invalid (nonexistent account, non-positive amount, or insufficient funds), return Optional.empty().

## 🧠Notes
- You may ignore the timestamp for now—it will be used in later stages.
- You may use any in-memory data structure.
- The system should be efficient enough to handle thousands of accounts and operations.

---
# 🏦 Stage 2: Tracking Top Account Activity

You're now extending the banking system to support activity tracking. The goal is to identify the most active accounts based on total value moved.

Update your interface to include the following method:

```java
List<String> topActivity(int timestamp, int n);
```
# 🔹 Operation: `topActivity`
**Purpose:** Return the top n most active accounts based on total value moved.

**Definition of Activity:**

- For each account, track the sum of all deposit and payment amounts.
- Ignore the number of transactions—only the total value matters.
- The timestamp parameter is provided but not used in this stage.

### ✅ Output Format
Return a list of strings in the format:
```
["account123(8000)", "account456(7500)", ...]
```
Where:
- "account123" is the account ID.
- 8000 is the total value moved (deposits + payments).

### 📊 Ranking Rules
- Sort accounts by total value moved in descending order.
- If two accounts have the same total, sort them by accountId in ascending lexicographic order.

### 🧠 Notes
- You may assume createAccount, deposit, and pay are already implemented from Stage 1.
- The system should be efficient enough to handle thousands of accounts and queries

---
# 🏦 Stage 3: Account Transfers

In this stage, you're extending the banking system to support **inter-account transfers**. Transfers are initiated by one account and must be explicitly accepted by the target account to complete. Transfers are time-sensitive and must be validated carefully.

Update your interface to include the following methods:

```java
Optional<String> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount);
boolean acceptTransfer(int timestamp, String accountId, String transferId);
```

## 🔹 Operation: `transfer`

**Purpose**: Initiate a transfer from one account to another.

**Rules**:
- Both `sourceAccountId` and `targetAccountId` must exist.
- The `sourceAccountId` must have sufficient funds to cover the `amount`.
- The `amount` must be a positive integer.
- If valid, the system holds the funds and returns a unique `transferId` in the format `"transferXX"`, where `XX` is a sequential number starting from 1.
- If invalid (e.g., insufficient funds, invalid accounts), return `Optional.empty()`.

**Transfer Lifecycle**:
- A transfer is **pending** until accepted.
- A transfer **expires after 24 hours** (86,400,000 milliseconds).
- Timestamps are provided in **milliseconds** and are guaranteed to be **monotonically increasing**.


## 🔹 Operation: `acceptTransfer`

**Purpose**: Complete a pending transfer by the target account.

**Rules**:
- The `accountId` must match the `targetAccountId` used in the original transfer.
- The transfer must still be valid (i.e., not expired).
- If valid, the funds are credited to the target account and the transfer is marked as complete.
- If expired, the funds are returned to the source account.
- Return `true` if the transfer was successfully completed.
- Return `false` if the transfer is invalid, expired, or mismatched.


## 🧠 Notes

- Transfers must be tracked with their creation timestamp and status (pending, completed, expired).
- Only one `acceptTransfer` call should succeed per transfer.
- The system must be efficient and consistent under concurrent operations.

---
# 🏦 Stage 4: Transaction History and Auditing

In this final stage, you're adding support for **auditing** and **transaction traceability**. The system must now be able to return a chronological log of all operations performed on a given account.

Add the following method to your interface:

```java
List<String> getTransactionLog(String accountId);
```

## 🔹 Operation: getTransactionLog
Purpose: Return a chronological list of all transactions associated with the given account.

### ✅ Log Format
Each entry in the list should be a string in the format:
```
"[timestamp] ACTION: details"
```
Where:
- `timestamp` is the original timestamp of the operation.
- `ACTION` is one of: `CREATE`, `DEPOSIT`, `PAY`, `TRANSFER_OUT`, `TRANSFER_IN`, `TRANSFER_EXPIRED`.
- `details` should include relevant information such as amount, target/source account, or transfer ID.

### 📋 Examples
```
[1697400000000] CREATE
[1697400100000] DEPOSIT: +5000
[1697400200000] PAY: -2000
[1697400300000] TRANSFER_OUT: -1000 to accountB (transfer7)
[1697400400000] TRANSFER_IN: +1000 from accountA (transfer7)
```

### 🧠 Notes
- The log must be ordered by timestamp (oldest to newest).
- Expired transfers should be logged as TRANSFER_EXPIRED with funds returned to the source.
- Only include transactions that affected the account (either directly or via transfer).
- This method is read-only and must not mutate any internal state.