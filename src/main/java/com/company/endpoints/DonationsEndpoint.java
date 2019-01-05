package com.company.endpoints;

import com.company.models.DonationEntity;
import com.company.services.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Path("donations")
public class DonationsEndpoint {

    protected DonationService donationService;

    @Inject
    public DonationsEndpoint(DonationService donationService) {
        this.donationService = donationService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleOne() {
        List<DonationEntity> donations = donationService.getAll(0, 999);

        return Response.status(Response.Status.OK).entity(donations).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleMany(@PathParam("id") Long id) {
        DonationEntity donation = donationService.getById(id);

        return Response.status(Response.Status.OK).entity(donation).build();
    }
}
