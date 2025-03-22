package com.api.intfinity.pos;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context HttpHeaders headers) {
        // Log all headers
        headers.getRequestHeaders().forEach((key, values) ->
                System.out.println(key + ": " + values)
        );

        System.out.println("received request");
        return "Hello from Quarkus REST";
    }
}