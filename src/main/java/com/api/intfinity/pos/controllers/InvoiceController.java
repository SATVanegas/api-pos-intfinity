package com.api.intfinity.pos.controllers;

import com.api.intfinity.pos.models.Invoice;
import com.api.intfinity.pos.services.InvoiceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/invoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvoiceController {

    @Inject
    InvoiceService invoiceService;

    @GET
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GET
    @Path("/{id}")
    public Response getInvoiceById(@PathParam("id") Long id) {
        return invoiceService.getInvoiceById(id)
                .map(invoice -> Response.ok(invoice).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response createInvoice(Invoice invoice) {
        invoiceService.createInvoice(invoice);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateInvoice(@PathParam("id") Long id, Invoice updatedInvoice) {
        if (invoiceService.updateInvoice(id, updatedInvoice)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    //En lugar de delete debemos cambiar a un estado de anulado
    @DELETE
    @Path("/{id}")
    public Response deleteInvoice(@PathParam("id") Long id) {
        if (invoiceService.deleteInvoice(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

