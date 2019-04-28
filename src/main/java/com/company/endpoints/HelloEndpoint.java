package com.company.endpoints;

import com.company.common.base.config.AppConfig;

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
@Path("hello")
public class HelloEndpoint {

    protected AppConfig appConfig;

    @Inject
    public HelloEndpoint(AppConfig appConfig) {
    }

    @GET
    public Response handle() {
        Object x = appConfig.getString("alpha");
        System.out.println(x);

        Object results = "Hello There";
        return Response.status(Response.Status.OK).entity(results).build();
    }
}
