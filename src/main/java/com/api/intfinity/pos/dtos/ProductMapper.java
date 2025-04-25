package com.api.intfinity.pos.dtos;


import com.api.intfinity.pos.dtos.*;
import com.api.intfinity.pos.models.*;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductMapper {





    // ------------------------- Product -------------------------
    public ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setCompanyId(product.getCompanyId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setBasePrice(product.getBasePrice());

        if (product.getVariations() != null) {
            List<VariationDTO> variationDTOs = product.getVariations().stream()
                    .map(this::toVariationDTO)
                    .collect(Collectors.toList());
            dto.setVariations(variationDTOs);
        }

        return dto;
    }

    // ------------------------- Attribute -------------------------
    public AttributeDTO toAttributeDTO(Attribute attribute) {
        if (attribute == null) {
            return null;
        }

        AttributeDTO dto = new AttributeDTO();
        dto.setId(attribute.getId());
        dto.setName(attribute.getName());

        if (attribute.getValueAttributes() != null) {
            List<ValueAttributeDTO> valueAttributeDTOs = attribute.getValueAttributes().stream()
                    .map(this::toValueAttributeDTO)
                    .collect(Collectors.toList());
            dto.setValueAttributes(valueAttributeDTOs);
        }

        return dto;
    }

    public Attribute toAttributeEntity(AttributeDTO dto) {
        if (dto == null) {
            return null;
        }

        Attribute attribute = new Attribute();
        attribute.setId(dto.getId());
        attribute.setName(dto.getName());

        // Nota: Los ValueAttributes se manejan generalmente en el servicio
        return attribute;
    }

    // ------------------------- Métodos adicionales para listas -------------------------
    public List<AttributeDTO> toAttributeDTOList(List<Attribute> attributes) {
        return attributes.stream()
                .map(this::toAttributeDTO)
                .collect(Collectors.toList());
    }

    public Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setCompanyId(dto.getCompanyId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBasePrice(dto.getBasePrice());

        // Nota: Las variaciones se manejan generalmente en el servicio
        return product;
    }

    // ------------------------- Variation -------------------------
    public VariationDTO toVariationDTO(Variation variation) {
        if (variation == null) {
            return null;
        }

        VariationDTO dto = new VariationDTO();
        dto.setId(variation.getId());
        dto.setPrice(variation.getPrice());

        if (variation.getVariationAttributes() != null) {
            List<VariationAttributeDTO> attributeDTOs = variation.getVariationAttributes().stream()
                    .map(this::toVariationAttributeDTO)
                    .collect(Collectors.toList());
            dto.setVariationAttributes(attributeDTOs);
        }

        return dto;
    }

    public Variation toVariationEntity(VariationDTO dto) {
        Variation variation = new Variation();
        variation.setId(dto.getId());
        variation.setPrice(dto.getPrice());

        // Nota: Los atributos y el producto se manejan generalmente en el servicio
        return variation;
    }

    // ------------------------- VariationAttribute -------------------------
    public VariationAttributeDTO toVariationAttributeDTO(VariationAttribute variationAttribute) {
        if (variationAttribute == null) {
            return null;
        }

        VariationAttributeDTO dto = new VariationAttributeDTO();
        dto.setId(variationAttribute.getId());
        dto.setValueAttribute(toValueAttributeDTO(variationAttribute.getValorAtributo()));

        return dto;
    }

    public VariationAttribute toVariationAttributeEntity(VariationAttributeDTO dto) {
        VariationAttribute variationAttribute = new VariationAttribute();
        variationAttribute.setId(dto.getId());

        if (dto.getValueAttribute() != null) {
            variationAttribute.setValorAtributo(toValueAttributeEntity(dto.getValueAttribute()));
        }

        return variationAttribute;
    }

    // ------------------------- ValueAttribute -------------------------
    public ValueAttributeDTO toValueAttributeDTO(ValueAttribute valueAttribute) {
        if (valueAttribute == null) {
            return null;
        }

        ValueAttributeDTO dto = new ValueAttributeDTO();
        dto.setId(valueAttribute.getId());
        dto.setValue(valueAttribute.getValue());

        if (valueAttribute.getAtributo() != null) {
            dto.setAttributeId(valueAttribute.getAtributo().getId());
            dto.setAttributeName(valueAttribute.getAtributo().getName());
        }

        return dto;
    }

    public ValueAttribute toValueAttributeEntity(ValueAttributeDTO dto) {
        ValueAttribute valueAttribute = new ValueAttribute();
        valueAttribute.setId(dto.getId());
        valueAttribute.setValue(dto.getValue());

        // Nota: El atributo padre se debe establecer en el servicio
        return valueAttribute;
    }

    // ------------------------- Métodos para listas -------------------------
    public List<ProductDTO> toProductDTOList(List<Product> products) {
        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<VariationDTO> toVariationDTOList(List<Variation> variations) {
        return variations.stream()
                .map(this::toVariationDTO)
                .collect(Collectors.toList());
    }
}