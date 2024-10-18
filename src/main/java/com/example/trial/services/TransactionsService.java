package com.example.trial.services;

import com.example.trial.entities.TransactionEntity;
import com.example.trial.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionsService {
    private final TransactionRepository transactionRepository;

    public TransactionsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionEntity> getBeneficiaryTransactions(Long id) {
        return transactionRepository.findBeneficiaryTransactions(id);
    }
}
