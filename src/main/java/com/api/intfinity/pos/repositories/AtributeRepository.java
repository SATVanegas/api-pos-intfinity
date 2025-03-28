package com.api.intfinity.pos.repositories;

import com.api.intfinity.pos.models.Attribute;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AtributeRepository implements PanacheRepository<Attribute> { // ✅ Sin parámetros de tipo
    // Métodos personalizados (opcional)
    public List<Attribute> findByNombre(String nombre) {
        return list("nombre", nombre);
    }
}
