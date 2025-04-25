package com.api.intfinity.pos.dtos;


public class VariationAttributeDTO {
    private Long id;
    private ValueAttributeDTO valueAttribute;

    // Constructores
    public VariationAttributeDTO() {
    }

    public VariationAttributeDTO(Long id, ValueAttributeDTO valueAttribute) {
        this.id = id;
        this.valueAttribute = valueAttribute;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValueAttributeDTO getValueAttribute() {
        return valueAttribute;
    }

    public void setValueAttribute(ValueAttributeDTO valueAttribute) {
        this.valueAttribute = valueAttribute;
    }
}