package com.example.trial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "beneficiaries")
public class BeneficiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiaryEntity", orphanRemoval = true)
    private List<AccountEntity> accounts;


    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) { this.accounts = accounts; }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) { this.lastName = lastName;}
}
