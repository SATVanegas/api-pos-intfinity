package com.api.intfinity.pos.services;

import com.api.intfinity.pos.dtos.*;
import com.api.intfinity.pos.dtos.ProductMapper;
import com.api.intfinity.pos.models.*;
import com.api.intfinity.pos.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepo;

    @Inject
    VariationRepository variationRepo;

    @Inject
    AtributeRepository attributeRepo;

    @Inject
    ValueAtributeRepository valueRepo;

    @Inject
    VariacionAtributeRepository variacionAttrRepo;

    @Inject
    ProductMapper productMapper;

    // ------------------------- Productos -------------------------
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        // Convertir DTO a Entity
        Product product = productMapper.toEntity(productDTO);

        // Asegurar que las variaciones tengan asignado el producto
        if (product.getVariations() != null) {
            for (Variation variation : product.getVariations()) {
                variation.setProduct(product);

                // Si hay atributos en las variaciones
                if (variation.getVariationAttributes() != null) {
                    for (VariationAttribute attr : variation.getVariationAttributes()) {
                        attr.setVariation(variation);
                    }
                }
            }
        }

        // Persistir el producto (cascada persistirá las variaciones)
        productRepo.persist(product);

        // Retornar el DTO con todos los datos actualizados
        return productMapper.toDTO(product);
    }

    public List<ProductDTO> getAllProductsWithVariations() {
        List<Product> products = productRepo.listAll();
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductWithVariations(Long id) {
        Product product = productRepo.findById(id);
        if (product == null) {
            throw new NotFoundException("Producto no encontrado");
        }
        return productMapper.toDTO(product);
    }

    // ------------------------- Variaciones -------------------------
    @Transactional
    public VariationDTO addVariation(Long productId, VariationDTO variationDTO) {
        Product product = productRepo.findById(productId);
        if (product == null) {
            throw new NotFoundException("Producto no encontrado");
        }

        // Convertir DTO a Entity
        Variation variation = productMapper.toVariationEntity(variationDTO);
        variation.setProduct(product);

        // Persistir la variación
        variationRepo.persist(variation);

        // Retornar el DTO actualizado
        return productMapper.toVariationDTO(variation);
    }

    public List<VariationDTO> getVariationsByProduct(Long productId) {
        List<Variation> variations = variationRepo.list("product.id", productId);
        return variations.stream()
                .map(productMapper::toVariationDTO)
                .collect(Collectors.toList());
    }

    // ------------------------- Atributos -------------------------
    @Transactional
    public AttributeDTO createAttribute(AttributeDTO attributeDTO) {
        Attribute attribute = new Attribute();
        attribute.setName(attributeDTO.getName());
        //attribute.setDescription(attributeDTO.getDescription());

        attributeRepo.persist(attribute);

        return productMapper.toAttributeDTO(attribute);
    }

    @Transactional
    public ValueAttributeDTO addAttributeValue(Long attributeId, ValueAttributeDTO valueDTO) {
        Attribute attribute = attributeRepo.findById(attributeId);
        if (attribute == null) {
            throw new NotFoundException("Atributo no encontrado");
        }

        ValueAttribute value = new ValueAttribute();
        value.setValue(valueDTO.getValue());
        value.setAtributo(attribute);

        valueRepo.persist(value);

        return productMapper.toValueAttributeDTO(value);
    }

    // ------------------------- Asignación -------------------------
    @Transactional
    public VariationAttributeDTO assignAttribute(Long variationId, Long valueId) {
        Variation variation = variationRepo.findById(variationId);
        ValueAttribute value = valueRepo.findById(valueId);

        if (variation == null || value == null) {
            throw new NotFoundException("Variación o valor no encontrado");
        }

        VariationAttribute va = new VariationAttribute();
        va.setVariation(variation);
        va.setValorAtributo(value);

        variacionAttrRepo.persist(va);

        return productMapper.toVariationAttributeDTO(va);
    }
}