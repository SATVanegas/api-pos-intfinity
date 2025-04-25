package com.api.intfinity.pos.dtos;

import java.util.List;

public class AttributeDTO {
    private Long id;
    private String name;
    private List<ValueAttributeDTO> valueAttributes;

    // Constructores
    public AttributeDTO() {
    }

    public AttributeDTO(Long id, String name, List<ValueAttributeDTO> valueAttributes) {
        this.id = id;
        this.name = name;
        this.valueAttributes = valueAttributes;
    }

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

    public List<ValueAttributeDTO> getValueAttributes() {
        return valueAttributes;
    }

    public void setValueAttributes(List<ValueAttributeDTO> valueAttributes) {
        this.valueAttributes = valueAttributes;
    }
}