package com.api.intfinity.pos.models;


import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "attribute")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "atributo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValueAttribute> valueAttributes;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ValueAttribute> getValueAttributes() {
        return valueAttributes;
    }

    public void setValueAttributes(List<ValueAttribute> valueAttributes) {
        this.valueAttributes = valueAttributes;
    }
}