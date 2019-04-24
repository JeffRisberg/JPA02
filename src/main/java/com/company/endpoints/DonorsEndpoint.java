package com.company.endpoints;

import com.company.models.CharityEntity;
import com.company.models.DonationEntity;
import com.company.models.DonorEntity;
import com.company.services.DonationService;
import com.company.services.DonorService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Path("donors")
public class DonorsEndpoint {

    protected DonorService donorService;

    @Inject
    public DonorsEndpoint(DonorService donorService) {
        this.donorService = donorService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(DonorEntity donor) {
        donor = donorService.create(donor);

        return Response.status(Response.Status.OK).entity(donor).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<DonorEntity> donors = donorService.getAll(0, 0);

        return Response.status(Response.Status.OK).entity(donors).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        List<DonorEntity> result = new ArrayList<>();
        DonorEntity donor = donorService.getById(id);

        if (donor != null) result.add(donor);

        return Response.status(Response.Status.OK).entity(result).build();
    }
}
