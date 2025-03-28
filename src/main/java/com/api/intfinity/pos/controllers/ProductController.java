package com.api.intfinity.pos.controllers;


import com.api.intfinity.pos.models.*;
import com.api.intfinity.pos.services.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService productService;

    // ====================== CRUD BÁSICO DE PRODUCTOS ======================
    @POST
    @Transactional
    public Response createProduct(Product product) {
        return Response.ok(productService.createProduct(product)).status(201).build();
    }

    @GET
    public List<Product> getAllProducts() {
        return productService.getAllProductsWithVariations();
    }

    @GET
    @Path("/{id}")
    public Response getProductWithDetails(@PathParam("id") Long id) {
        Product product = productService.getProductWithVariations(id);
        return product != null ? Response.ok(product).build() : Response.status(404).build();
    }

    // ====================== GESTIÓN DE VARIACIONES ======================
    @POST
    @Path("/{productId}/variations")
    @Transactional
    public Response addVariation(@PathParam("productId") Long productId, Variation variation) {
        Variation created = productService.addVariation(productId, variation);
        return Response.ok(created).status(201).build();
    }

    @GET
    @Path("/{productId}/variations")
    public List<Variation> getVariations(@PathParam("productId") Long productId) {
        return productService.getVariationsByProduct(productId);
    }

    // ====================== GESTIÓN DE ATRIBUTOS ======================
    @POST
    @Path("/attributes")
    @Transactional
    public Response createAttribute(Attribute attribute) {
        return Response.ok(productService.createAttribute(attribute)).status(201).build();
    }

    @POST
    @Path("/attributes/{attributeId}/values")
    @Transactional
    public Response addAttributeValue(@PathParam("attributeId") Long attributeId, ValueAttribute value) {
        ValueAttribute created = productService.addAttributeValue(attributeId, value);
        return Response.ok(created).status(201).build();
    }

    // ====================== ASIGNAR ATRIBUTOS A VARIACIONES ======================
    @POST
    @Path("/variations/{variationId}/attributes")
    @Transactional
    public Response assignAttributeToVariation(
            @PathParam("variationId") Long variationId,
            @QueryParam("valueId") Long valueId
    ) {
        VariationAttribute assignment = productService.assignAttribute(variationId, valueId);
        return Response.ok(assignment).status(201).build();
    }
}
