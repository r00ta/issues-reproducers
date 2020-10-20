package com.redhat.developer;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import io.quarkus.runtime.Startup;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class Emitter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Emitter.class);

    private final PublishSubject<String> eventSubject;

    private int counter = 0;

    public Emitter() {
        this.eventSubject = PublishSubject.create();
    }

    @PostConstruct
    public void publish() {
        this.emit("startup");
    }

    @Outgoing("my-topic")
    public Publisher<String> getEventPublisher() {
        return eventSubject.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void emit(final String payload) {
        LOGGER.info("Emit counter: " + counter++);
        eventSubject.onNext(payload);
    }
}
