package com.company.endpoints;

import com.company.models.Tenant;
import com.company.services.TenantService;
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
 * @since 12/15/17
 */
@Singleton
@Path("tenants")
public class TenantEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(TenantEndpoint.class);

    protected TenantService tenantService;

    @Inject
    public TenantEndpoint(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleOne() {
        List<Tenant> tenants = tenantService.getList(0, 999);

        return Response.status(Response.Status.OK).entity(tenants).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleMany(@PathParam("id") Long id) {
        Tenant tenant = tenantService.getOne(id);

        return Response.status(Response.Status.OK).entity(tenant).build();
    }
}
