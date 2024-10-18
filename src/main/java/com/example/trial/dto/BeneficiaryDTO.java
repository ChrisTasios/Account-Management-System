package com.example.trial.dto;

public class BeneficiaryDTO {

    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BeneficiaryDTO(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
