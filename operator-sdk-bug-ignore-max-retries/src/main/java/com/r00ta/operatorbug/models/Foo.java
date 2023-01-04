package com.r00ta.operatorbug.models;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("com.r00ta.operatorbug")
@Version("v1alpha1")
@ShortNames("foo")
public class Foo extends CustomResource<FooSpec, FooStatus> implements Namespaced {

}
