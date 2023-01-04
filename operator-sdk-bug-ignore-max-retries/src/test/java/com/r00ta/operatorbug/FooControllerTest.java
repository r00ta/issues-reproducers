package com.r00ta.operatorbug;

import java.time.Duration;
import java.util.Collections;

import javax.inject.Inject;

import com.r00ta.operatorbug.controllers.FooController;
import com.r00ta.operatorbug.models.Foo;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.Operator;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kubernetes.client.WithOpenShiftTestServer;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@WithOpenShiftTestServer
public class FooControllerTest {

    @Inject
    Operator operator;

    @Inject
    FooController fooController;

    @Inject
    KubernetesClient kubernetesClient;

    @BeforeEach
    void setup() {
        operator.start();
    }

    @Test
    void testCreateNewBridgeExecutorWithoutSecrets() {
        // Given
        Foo foo = new Foo();
        foo.setMetadata(
                new ObjectMetaBuilder()
                        .withNamespace("test")
                        .withName("foo")
                        .withLabels(Collections.singletonMap("app.kubernetes.io/managed-by", "foocontroller"))
                        .build()
        );


        // When
        kubernetesClient.resources(Foo.class)
                .inNamespace("test")
                .create(foo);

        // Then
        Awaitility.await()
                .atMost(Duration.ofMinutes(2))
                .pollInterval(Duration.ofSeconds(5))
                .untilAsserted(() -> {
                    Foo retrievedFoo = kubernetesClient.resources(Foo.class)
                            .inNamespace("test")
                            .withName("foo")
                            .get();
                    assertThat(retrievedFoo.getStatus().getExceptionCount()).isEqualTo(5);
                });
    }
}
