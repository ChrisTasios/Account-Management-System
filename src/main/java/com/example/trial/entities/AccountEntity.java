package com.example.trial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    private BeneficiaryEntity beneficiaryEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountEntity", orphanRemoval = true)
    private List<TransactionEntity> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TransactionEntity> getTransactionEntity() {
        return transactions;
    }
    public void setTransactionEntity(List<TransactionEntity> transactions) { this.transactions = transactions; }

    public BeneficiaryEntity getBeneficiaryEntity() {
        return beneficiaryEntity;
    }
    public void setBeneficiaryEntity(BeneficiaryEntity beneficiaryEntity) { this.beneficiaryEntity = beneficiaryEntity; }
}
