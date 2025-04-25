package com.api.intfinity.pos.dtos;


public class ValueAttributeDTO {
    private Long id;
    private String value;
    private Long attributeId;
    private String attributeName;

    // Constructores
    public ValueAttributeDTO() {
    }

    public ValueAttributeDTO(Long id, String value, Long attributeId, String attributeName) {
        this.id = id;
        this.value = value;
        this.attributeId = attributeId;
        this.attributeName = attributeName;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
