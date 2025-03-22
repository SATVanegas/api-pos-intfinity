package com.api.intfinity.pos.services;

import com.api.intfinity.pos.models.Invoice;
import com.api.intfinity.pos.repositories.InvoiceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class InvoiceService {

    @Inject
    InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.listAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findByIdOptional(id);
    }

    @Transactional
    public void createInvoice(Invoice invoice) {
        invoiceRepository.persist(invoice);
    }

    @Transactional
    public boolean updateInvoice(Long id, Invoice updatedInvoice) {
        return invoiceRepository.findByIdOptional(id).map(invoice -> {
            invoice.invoiceNumber = updatedInvoice.invoiceNumber;
            invoice.customer = updatedInvoice.customer;
            invoice.companyId = updatedInvoice.companyId;
            invoice.createdBy = updatedInvoice.createdBy;
            invoice.subtotal = updatedInvoice.subtotal;
            invoice.tax = updatedInvoice.tax;
            invoice.total = updatedInvoice.total;
            invoice.paymentStatus = updatedInvoice.paymentStatus;
            invoice.paymentMethod = updatedInvoice.paymentMethod;
            invoice.notes = updatedInvoice.notes;
            invoice.items = updatedInvoice.items;
            return true;
        }).orElse(false);
    }

    @Transactional
    public boolean deleteInvoice(Long id) {
        return invoiceRepository.deleteById(id);
    }
}
