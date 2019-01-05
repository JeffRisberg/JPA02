package com.company.endpoints;

import com.company.models.CharityEntity;
import com.company.models.DonationEntity;
import com.company.services.DonationService;
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
@Path("donations")
public class DonationsEndpoint {

    protected DonationService donationService;

    @Inject
    public DonationsEndpoint(DonationService donationService) {
        this.donationService = donationService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(DonationEntity donation) {
        donation = donationService.create(donation);

        return Response.status(Response.Status.OK).entity(donation).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<DonationEntity> donations = donationService.getAll(0, 0);

        return Response.status(Response.Status.OK).entity(donations).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        List<DonationEntity> result = new ArrayList<>();
        DonationEntity donation = donationService.getById(id);

        if (donation != null) result.add(donation);

        return Response.status(Response.Status.OK).entity(result).build();
    }
}
