package com.company.endpoints;

import com.company.models.CharityEntity;
import com.company.services.CharityService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CharityEntity charity) {
        charity = charityService.create(charity);

        return Response.status(Response.Status.OK).entity(charity).build();
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
        List<CharityEntity> result = new ArrayList<>();
        CharityEntity charity = charityService.getById(id);

        if (charity != null) result.add(charity);

        return Response.status(Response.Status.OK).entity(result).build();
    }
}
