package com.example.trial.dto;

import com.example.trial.entities.enums.ActionType;

import java.time.LocalDate;

public class TransactionDTO {

    private Long transaction_id;
    public Long getTransaction_id() { return transaction_id; }
    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    private Long account_id;
    public Long getAccount_id() { return account_id; }
    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    private Double amount;
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private LocalDate date;
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    private ActionType type;
    public ActionType getType() { return  type; }
    public void setType(ActionType type) {
        this.type = type;
    }

    public TransactionDTO(Long transaction_id, Long account_id, Double amount, LocalDate date, ActionType type) {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
}
