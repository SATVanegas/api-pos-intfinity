package com.api.intfinity.pos.repositories;

import com.api.intfinity.pos.models.ValueAttribute;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValueAtributeRepository implements PanacheRepository<ValueAttribute> {}
