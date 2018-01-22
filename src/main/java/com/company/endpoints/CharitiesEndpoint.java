package com.company.endpoints;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
@Singleton
@Path("charities")
public class CharitiesEndpoint {

    @Inject
    public CharitiesEndpoint() {
    }

    @GET
    public Response handle() {
        Object results = "Hello There";
        return Response.status(Response.Status.OK).entity(results).build();
    }
}