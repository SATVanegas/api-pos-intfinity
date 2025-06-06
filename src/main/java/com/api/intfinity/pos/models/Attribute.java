package com.api.intfinity.pos.models;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "attribute")
public class Attribute extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "atributo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValueAttribute> valueAttributes;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ValueAttribute> getValueAttributes() {
        return valueAttributes;
    }

    public void setValueAttributes(List<ValueAttribute> valueAttributes) {
        this.valueAttributes = valueAttributes;
    }
}