package com.api.intfinity.pos.services;


import com.api.intfinity.pos.models.*;
import com.api.intfinity.pos.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

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

    // ------------------------- Productos -------------------------
    @Transactional
    public Product createProduct(Product product) {
        productRepo.persist(product);
        return product;
    }

    public List<Product> getAllProductsWithVariations() {
        return productRepo.listAll();
    }

    public Product getProductWithVariations(Long id) {
        return productRepo.findById(id);
    }

    // ------------------------- Variaciones -------------------------
    @Transactional
    public Variation addVariation(Long productId, Variation variation) {
        Product product = productRepo.findById(productId);
        if (product == null) throw new NotFoundException("Producto no encontrado");

        variation.setProducto(product);
        variationRepo.persist(variation);
        return variation;
    }

    public List<Variation> getVariationsByProduct(Long productId) {
        return variationRepo.list("producto.id", productId);
    }

    // ------------------------- Atributos -------------------------
    @Transactional
    public Attribute createAttribute(Attribute attribute) {
        attributeRepo.persist(attribute);
        return attribute;
    }

    @Transactional
    public ValueAttribute addAttributeValue(Long attributeId, ValueAttribute value) {
        Attribute attribute = attributeRepo.findById(attributeId);
        if (attribute == null) throw new NotFoundException("Atributo no encontrado");

        value.setAtributo(attribute);
        valueRepo.persist(value);
        return value;
    }

    // ------------------------- Asignación -------------------------
    @Transactional
    public VariationAttribute assignAttribute(Long variationId, Long valueId) {
        Variation variation = variationRepo.findById(variationId);
        ValueAttribute value = valueRepo.findById(valueId);

        if (variation == null || value == null) {
            throw new NotFoundException("Variación o valor no encontrado");
        }

        VariationAttribute va = new VariationAttribute();
        va.setVariacion(variation);
        va.setValorAtributo(value);
        variacionAttrRepo.persist(va);

        return va;
    }
}
