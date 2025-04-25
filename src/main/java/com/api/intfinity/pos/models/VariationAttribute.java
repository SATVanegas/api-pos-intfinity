package com.api.intfinity.pos.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "variation_attribute")
public class VariationAttribute extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "variacion_id", nullable = false)
    private Variation variation;

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

    public Variation getVariation() {
        return variation;
    }

    public void setVariation(Variation variation) {
        this.variation = variation;
    }

    public ValueAttribute getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(ValueAttribute valorAtributo) {
        this.valorAtributo = valorAtributo;
    }
}