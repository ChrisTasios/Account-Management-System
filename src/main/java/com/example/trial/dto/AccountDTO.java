package com.example.trial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {

    private Long account_id;
    public Long getAccount_id() { return account_id; }
    public void setAccount_id(Long account_id) { this.account_id = account_id; }

    private Long beneficiary_id;
    public Long getBeneficiary_id() { return beneficiary_id; }
    public void setBeneficiary_id(Long beneficiary_id) { this.beneficiary_id = beneficiary_id; }

    private Double net_balance;
    public Double getNet_balance() { return net_balance; }
    public void setNet_balance(Double net_balance) { this.net_balance = net_balance; }

    public AccountDTO(Long account_id, Long beneficiary_id) {
        this.account_id = account_id;
        this.beneficiary_id = beneficiary_id;
    }

    public AccountDTO(Long account_id, Long beneficiary_id, Double net_balance) {
        this.account_id = account_id;
        this.beneficiary_id = beneficiary_id;
        this.net_balance = net_balance;
    }
}
