package com.redhat.developer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/force")
public class EmitterResource {

    @Inject
    Emitter publisher;

    @GET
    public Response force(){
//        publisher.publish();
        return Response.ok().build();
    }
}
