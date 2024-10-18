package com.example.trial.repositories;

import com.example.trial.dto.AccountDTO;
import com.example.trial.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "SELECT * FROM Accounts  WHERE beneficiary_id = ?1", nativeQuery = true)
    List<AccountEntity> findBeneficiaryAccounts(final Long id);

   @Query(value = "Select account_id, " +
           "SUM(CASE WHEN type = 'DEPOSIT' THEN amount ELSE 0 END) - " +
           "SUM(CASE WHEN type = 'WITHDRAWAL' THEN amount ELSE 0 END) AS net_balance " +
           "FROM transactions WHERE account_id IN (SELECT id FROM accounts WHERE beneficiary_id = ?1) GROUP BY account_id", nativeQuery = true)
    List<Object[]> findBeneficiaryBalance(final Long id);
}
