package com.api.intfinity.pos.dtos;

import java.util.List;

public class VariationDTO {
    private Long id;
    private Double price;
    private List<VariationAttributeDTO> variationAttributes;

    // Constructores
    public VariationDTO() {
    }

    public VariationDTO(Long id, Double price, List<VariationAttributeDTO> variationAttributes) {
        this.id = id;
        this.price = price;
        this.variationAttributes = variationAttributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<VariationAttributeDTO> getVariationAttributes() {
        return variationAttributes;
    }

    public void setVariationAttributes(List<VariationAttributeDTO> variationAttributes) {
        this.variationAttributes = variationAttributes;
    }
}