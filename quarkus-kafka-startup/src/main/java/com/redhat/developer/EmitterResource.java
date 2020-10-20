package com.redhat.developer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/force")
public class EmitterResource {

    @Inject
    Emitter emitter;

    @GET
    public Response force(){
        emitter.emit("forced");
        return Response.ok().build();
    }
}
