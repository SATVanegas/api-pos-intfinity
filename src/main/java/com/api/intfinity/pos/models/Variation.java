package com.api.intfinity.pos.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "variation")
public class Variation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Double price;

    @OneToMany(mappedBy = "variation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VariationAttribute> variationAttributes;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<VariationAttribute> getVariationAttributes() {
        return variationAttributes;
    }

    public void setVariationAttributes(List<VariationAttribute> variationAttributes) {
        this.variationAttributes = variationAttributes;
    }
}