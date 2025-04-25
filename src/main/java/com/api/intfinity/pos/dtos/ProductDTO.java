package com.api.intfinity.pos.dtos;

// ProductDTO.java

import java.util.List;
import java.util.UUID;

public class ProductDTO {
    private Long id;
    private UUID companyId;
    private String name;
    private String description;
    private Double basePrice;
    private List<VariationDTO> variations;

    // Constructores
    public ProductDTO() {
    }

    public ProductDTO(Long id, UUID companyId, String name, String description, Double basePrice, List<VariationDTO> variations) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.variations = variations;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public List<VariationDTO> getVariations() {
        return variations;
    }

    public void setVariations(List<VariationDTO> variations) {
        this.variations = variations;
    }
}
