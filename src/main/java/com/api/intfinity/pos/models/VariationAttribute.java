package com.api.intfinity.pos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "variation_attribute")
public class VariationAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "variacion_id", nullable = false)
    private Variation variacion;

    @ManyToOne
    @JoinColumn(name = "valor_atributo_id", nullable = false)
    private ValueAttribute valorAtributo;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Variation getVariacion() {
        return variacion;
    }

    public void setVariacion(Variation variacion) {
        this.variacion = variacion;
    }

    public ValueAttribute getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(ValueAttribute valorAtributo) {
        this.valorAtributo = valorAtributo;
    }
}