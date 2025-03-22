package com.api.intfinity.pos.repositories;

import com.api.intfinity.pos.models.Invoice;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoiceRepository implements PanacheRepository<Invoice> {
}