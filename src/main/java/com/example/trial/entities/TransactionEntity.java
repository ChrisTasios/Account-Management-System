package com.example.trial.entities;

import com.example.trial.entities.enums.ActionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ActionType type;

    @Column(name = "date")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public AccountEntity getAccount() {
        return accountEntity;
    }

    public void setAccount(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
