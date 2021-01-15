package com.redhat.developer;

import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.quarkus.runtime.StartupEvent;

@Singleton
@Startup
public class Emitter {

    @Inject
    MyPublisher myPublisher;

    public void publish(@Observes StartupEvent event) {
        myPublisher.emit("startup");
    }
}
