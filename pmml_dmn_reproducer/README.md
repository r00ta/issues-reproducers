# PMML LM model + DMN scenario reproducer 

## How to reproduce

```bash
mvn clean package -DskipTests
java -jar target/quarkus-app/quarkus-run.jar
```

Or 

```bash
mvn clean compile quarkus:dev
```

to get more info from the stacktrace 


```
2021-04-07 14:16:41,020 ERROR [org.kie.dmn.cor.com.DMNCompilerImpl] (Quarkus Main Thread) Error compiling model from source.: java.lang.NullPointerException
	at org.drools.core.io.impl.UrlResource.<init>(UrlResource.java:74)
	at org.drools.core.io.impl.ResourceFactoryServiceImpl.newUrlResource(ResourceFactoryServiceImpl.java:116)
	at org.kie.internal.io.ResourceFactory.newUrlResource(ResourceFactory.java:50)
	at org.kie.dmn.core.compiler.DMNCompilerImpl.resolveRelativeResource(DMNCompilerImpl.java:295)
	at org.kie.dmn.core.compiler.DMNCompilerImpl.processPMMLImport(DMNCompilerImpl.java:249)
	at org.kie.dmn.core.compiler.DMNCompilerImpl.compile(DMNCompilerImpl.java:227)
	at org.kie.dmn.core.compiler.DMNCompilerImpl.compile(DMNCompilerImpl.java:186)
	at org.kie.dmn.core.internal.utils.DMNRuntimeBuilder$DMNRuntimeBuilderConfigured.fromResources(DMNRuntimeBuilder.java:209)
	at org.kie.kogito.dmn.DMNKogito.createGenericDMNRuntime(DMNKogito.java:67)
	at org.kie.kogito.dmn.AbstractDecisionModels.init(AbstractDecisionModels.java:40)
	at org.kie.kogito.app.DecisionModels.<clinit>(DecisionModels.java:24)
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:398)
	at org.kie.kogito.app.DecisionModels_Bean.<init>(DecisionModels_Bean.zig:92)
	at io.quarkus.arc.setup.Default_ComponentsProvider.addBeans1(Default_ComponentsProvider.zig:305)
	at io.quarkus.arc.setup.Default_ComponentsProvider.getComponents(Default_ComponentsProvider.zig:38)
	at io.quarkus.arc.impl.ArcContainerImpl.<init>(ArcContainerImpl.java:115)
	at io.quarkus.arc.Arc.initialize(Arc.java:20)
	at io.quarkus.arc.runtime.ArcRecorder.getContainer(ArcRecorder.java:24)
	at io.quarkus.deployment.steps.ArcProcessor$generateResources-1025303321.deploy_0(ArcProcessor$generateResources-1025303321.zig:76)
	at io.quarkus.deployment.steps.ArcProcessor$generateResources-1025303321.deploy(ArcProcessor$generateResources-1025303321.zig:40)
	at io.quarkus.runner.ApplicationImpl.<clinit>(ApplicationImpl.zig:191)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
	at java.base/java.lang.Class.newInstance(Class.java:584)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:65)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:42)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:119)
	at io.quarkus.runner.GeneratedMain.main(GeneratedMain.zig:29)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at io.quarkus.runner.bootstrap.StartupActionImpl$3.run(StartupActionImpl.java:134)
	at java.base/java.lang.Thread.run(Thread.java:834)

```