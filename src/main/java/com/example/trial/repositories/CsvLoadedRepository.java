package com.example.trial.repositories;

import com.example.trial.entities.CsvLoadedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvLoadedRepository extends JpaRepository<CsvLoadedEntity, Long> {
}
