# Account Management System - Java Exercise

## Description

In this exercise, we implement an **Account Management System** using Java. 

The system will utilize three attached CSV files as data sources:
- `beneficiaries.csv`: Each record has a unique `beneficiaryId`.
- `accounts.csv`: Each record has a unique `accountId`.
- `transactions.csv`: Each record has a unique `transactionId`.  
  The date format is **MM/DD/YY**.

The set of RESTful APIs will have the following functionality:

1. **Retrieve Beneficiary Details**  
   Return the full details of a beneficiary based on their `beneficiaryId`.

2. **Retrieve Beneficiary Accounts**  
   Return all accounts associated with a specific beneficiary.

3. **Retrieve Beneficiary Transactions**  
   Return all transactions associated with a beneficiary (via their accounts).

4. **Retrieve Beneficiary Account Balances**  
   Calculate and return the total balance across all accounts of a beneficiary.

5. **Retrieve Largest Withdrawal in the Last Month**  
   Return the single largest withdrawal transaction for a beneficiary that occurred in the past month.
