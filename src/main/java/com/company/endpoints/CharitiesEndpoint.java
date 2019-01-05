package com.company.endpoints;

import com.company.services.CharityService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
@Slf4j
@Singleton
@Path("charities")
public class CharitiesEndpoint {

    protected CharityService charityService;

    @Inject
    public CharitiesEndpoint(CharityService charityService) {
        this.charityService = charityService;
    }

    @GET
    public Response handle() {
        Object results = "Hello There";
        return Response.status(Response.Status.OK).entity(results).build();
    }
}
