package com.example.trial.services;

import com.example.trial.entities.BeneficiaryEntity;
import com.example.trial.repositories.BeneficiaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BeneficiariesService {
    private final BeneficiaryRepository beneficiaryRepository;

    public BeneficiariesService(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    public Optional<BeneficiaryEntity> getBeneficiary(Long id) {
        return beneficiaryRepository.findById(id);
    }
}
