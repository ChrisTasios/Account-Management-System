package com.example.trial.repositories;

import com.example.trial.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(value = "SELECT * FROM transactions WHERE account_id IN (SELECT id from accounts where beneficiary_id = ?1) order by account_id", nativeQuery = true)
    List<TransactionEntity> findBeneficiaryTransactions(final Long id);

}
