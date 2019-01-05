package com.company.endpoints;

import com.company.models.CharityEntity;
import com.company.services.CharityService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CharityEntity> charities = charityService.getAll(0, 0);

        return Response.status(Response.Status.OK).entity(charities).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        CharityEntity charity = charityService.getById(id);

        return Response.status(Response.Status.OK).entity(charity).build();
    }
}
