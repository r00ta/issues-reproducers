package com.r00ta.operatorbug.controllers;

import java.util.Collections;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.r00ta.operatorbug.models.Foo;
import com.r00ta.operatorbug.models.FooStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.ErrorStatusHandler;
import io.javaoperatorsdk.operator.api.reconciler.ErrorStatusUpdateControl;
import io.javaoperatorsdk.operator.api.reconciler.EventSourceContext;
import io.javaoperatorsdk.operator.api.reconciler.EventSourceInitializer;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import io.javaoperatorsdk.operator.processing.event.source.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@ControllerConfiguration(name = FooController.NAME, labelSelector = "app.kubernetes.io/managed-by=foocontroller")
public class FooController implements Reconciler<Foo>,
                                      EventSourceInitializer<Foo>,
                                      ErrorStatusHandler<Foo> {

    public static final String NAME = "foocontroller";
    private static final Logger LOGGER = LoggerFactory.getLogger(FooController.class);
    @Inject
    KubernetesClient kubernetesClient;

    @Override
    public UpdateControl<Foo> reconcile(Foo foo, Context<Foo> context) {
        LOGGER.info("Create or update Foo: '{}' in namespace '{}'",
                    foo.getMetadata().getName(),
                    foo.getMetadata().getNamespace());

        throw new RuntimeException("NICE TRY");
    }

    @Override
    public ErrorStatusUpdateControl<Foo> updateErrorStatus(Foo foo, Context<Foo> context, Exception e) {
        LOGGER.info("Retry number '{}'", context.getRetryInfo().get().getAttemptCount());
        foo.setStatus(new FooStatus(context.getRetryInfo().get().getAttemptCount()));
        if (context.getRetryInfo().isPresent() && context.getRetryInfo().get().isLastAttempt()) {
            LOGGER.info("This is the last try. Count = '{}'", context.getRetryInfo().get().getAttemptCount());
            return ErrorStatusUpdateControl.updateStatus(foo);
        }
        return ErrorStatusUpdateControl.updateStatus(foo);
    }

    @Override
    public Map<String, EventSource> prepareEventSources(EventSourceContext<Foo> eventSourceContext) {
        return Collections.emptyMap();
    }
}
