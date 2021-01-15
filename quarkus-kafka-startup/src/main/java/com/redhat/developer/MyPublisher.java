package com.redhat.developer;

import javax.enterprise.context.ApplicationScoped;

import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MyPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyPublisher.class);

    private final PublishSubject<String> eventSubject = PublishSubject.create();

    private int counter = 0;

    @Outgoing("my-topic")
    public Publisher<String> getEventPublisher() {
        return eventSubject.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void emit(final String payload) {
        LOGGER.info("Emit counter: " + counter++);
        eventSubject.onNext(payload);
    }
}
