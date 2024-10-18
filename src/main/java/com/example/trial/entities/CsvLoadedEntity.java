package com.example.trial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "loadedCsv")
public class CsvLoadedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    @Column
    private Boolean csvEntries;
    public Boolean isCsvEntries() {
        return csvEntries;
    }
    public void setCsvEntries(Boolean csvEntries) { this.csvEntries = csvEntries; }

    public CsvLoadedEntity(Boolean csvEntries) {
        this.csvEntries = csvEntries;
    }
}
