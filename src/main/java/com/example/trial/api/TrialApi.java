package com.example.trial.api;

import com.example.trial.dto.AccountDTO;
import com.example.trial.dto.BeneficiaryDTO;
import com.example.trial.dto.TransactionDTO;
import com.example.trial.entities.AccountEntity;
import com.example.trial.entities.BeneficiaryEntity;
import com.example.trial.entities.TransactionEntity;
import com.example.trial.services.AccountsService;
import com.example.trial.services.BeneficiariesService;
import com.example.trial.services.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TrialApi {

    private final BeneficiariesService beneficiariesService;
    private final AccountsService accountsService;
    private final TransactionsService transactionsService;

    public TrialApi(BeneficiariesService beneficiariesService, AccountsService accountsService, TransactionsService transactionsService) {
        this.beneficiariesService = beneficiariesService;
        this.accountsService = accountsService;
        this.transactionsService = transactionsService;
    }

    @GetMapping("/beneficiaries/{id}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiary(@PathVariable final Long id) {
        Optional<BeneficiaryEntity> optionalBeneficiary = beneficiariesService.getBeneficiary(id);
        if (optionalBeneficiary.isPresent()) {
            BeneficiaryEntity beneficiary  = optionalBeneficiary.get();
            BeneficiaryDTO dto = new BeneficiaryDTO(beneficiary.getId(), beneficiary.getName(), beneficiary.getLastName());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/beneficiaries/{id}/accounts")
    public ResponseEntity<List<AccountDTO>> getBeneficiaryAccounts(@PathVariable final Long id) {
        List<AccountEntity> entities = accountsService.getBeneficiaryAccounts(id);
        return ResponseEntity.ok(entities.stream()
                .map(accountEntity -> new AccountDTO(accountEntity.getId(),
                        accountEntity.getBeneficiaryEntity().getId()))
                .collect(Collectors.toList()));
    }

    @GetMapping("/beneficiaries/{id}/transactions")
    public ResponseEntity<List<TransactionDTO>> getBeneficiaryTransactions(@PathVariable final Long id) {
        List<TransactionEntity> transactionEntities = transactionsService.getBeneficiaryTransactions(id);
        return ResponseEntity.ok(transactionEntities.stream()
                .map(transactionEntity -> new TransactionDTO(transactionEntity.getId(),
                        transactionEntity.getAccount().getId(),
                        transactionEntity.getAmount(),
                        transactionEntity.getDate(),
                        transactionEntity.getType()))
                .collect(Collectors.toList()));
    }

    @GetMapping("/beneficiaries/{id}/balance")
    public ResponseEntity<List<AccountDTO>> getBeneficiaryBalance(@PathVariable final Long id) {
        return ResponseEntity.ok(accountsService.getAccountsBalance(id));
    }

    @GetMapping("/beneficiaries/{id}/withdrawal/montly")
    public ResponseEntity<List<AccountDTO>> getBeneficiaryMaxWithdrawalMontly(@PathVariable final Long id) {
        return ResponseEntity.ok(accountsService.getMaxMonthlyWithdrawal(id));
    }
}
