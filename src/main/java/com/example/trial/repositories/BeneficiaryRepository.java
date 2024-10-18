package com.example.trial.repositories;

import com.example.trial.entities.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, Long> {
}
