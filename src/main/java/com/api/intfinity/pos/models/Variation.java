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
    @JoinColumn(name = "producto_id", nullable = false)
    private Product producto;

    private Double precio;

    @OneToMany(mappedBy = "variacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VariationAttribute> variacionAtributes;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<VariationAttribute> getVariacionAtributes() {
        return variacionAtributes;
    }

    public void setVariacionAtributes(List<VariationAttribute> variacionAtributes) {
        this.variacionAtributes = variacionAtributes;
    }
}