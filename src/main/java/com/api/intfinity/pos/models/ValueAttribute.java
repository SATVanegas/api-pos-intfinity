package com.api.intfinity.pos.models;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "value_attribute")
public class ValueAttribute extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "atributo_id", nullable = false)
    private Attribute atributo;

    private String valor;
    private Double precio_adicional;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attribute getAtributo() {
        return atributo;
    }

    public void setAtributo(Attribute atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Double getPrecio_adicional() {
        return precio_adicional;
    }

    public void setPrecio_adicional(Double precio_adicional) {
        this.precio_adicional = precio_adicional;
    }
}