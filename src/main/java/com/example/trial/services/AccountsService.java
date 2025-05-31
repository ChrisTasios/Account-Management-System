package com.example.trial.services;

import com.example.trial.dto.AccountDTO;
import com.example.trial.entities.AccountEntity;
import com.example.trial.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountsService {
    private final AccountRepository accountRepository;

    public AccountsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountEntity> getBeneficiaryAccounts(Long id) {
        return  accountRepository.findBeneficiaryAccounts(id);
    }

    public List<AccountDTO> getAccountsBalance(Long id) {
        return accountRepository.findBeneficiaryBalance(id).stream()
                .map(result -> new AccountDTO((Long) result[0], id,  (Double) result[1]))
                .collect(Collectors.toList());
    }

    public List<AccountDTO> getMaxMonthlyWithdrawal(Long id) {
        return accountRepository.findBeneficiaryTopMonhtlyWithdraw(id).stream()
                .map(result -> new AccountDTO((Long) result[0], id,  (Double) result[1]))
                .collect(Collectors.toList());
    }
}
