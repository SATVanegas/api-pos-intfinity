package com.api.intfinity.pos.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "table_")
public class Table_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private UUID company;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UUID getCompany() {
        return company;
    }

    public void setCompany(UUID company) {
        this.company = company;
    }
}