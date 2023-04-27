# CDEvents Java SDK

Java SDK to produce [CDEvents](https://cdevents.dev).

The SDK can be used to create CDEvents and render as CloudEvents to send them to a specific CloudEvents broker

## Add dependency modules

```xml
<dependency>
  <groupId>dev.cdevents.sdk-java</groupId>
  <artifactId>cdevents-sdk-java</artifactId>
   <version>${cdevents.version}</version>
</dependency>

 <dependency>
    <groupId>io.cloudevents</groupId>
    <artifactId>cloudevents-core</artifactId>
    <version>${cloudevents.version}</version>
</dependency>
```

## Create your first CDEvent

Below is the example of creating a new [PipelineRun-finished](https://cdevents.dev/docs/core/#pipelinerun-finished) event,

```java
public class CDEventsExample {

    public static void main(String args[]){
        /*when creating new object of any CDEvent type, the event will be initialized with
        context.id, context.type, context.version, context.timestamp
        and subject.type */
        PipelineRunFinishedCDEvent pipelineRunFinishedCDEvent = new PipelineRunFinishedCDEvent();

        /* set the required context fields to the pipelineRunFinishedCDEvent */
        pipelineRunFinishedCDEvent.setSource(URI.create("http://dev.cdevents"));

        /* set the required subject fields to the pipelineRunFinishedCDEvent */
        pipelineRunFinishedCDEvent.setSubjectId("/dev/pipeline/run/1");
        pipelineRunFinishedCDEvent.setSubjectSource(URI.create("http://dev.pipeline.run/source"));
        pipelineRunFinishedCDEvent.setSubjectUrl(URI.create("http://dev.pipeline.run/url"));
        pipelineRunFinishedCDEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS);
        pipelineRunFinishedCDEvent.setSubjectPipelineName("testPipeline");
        pipelineRunFinishedCDEvent.setSubjectErrors("pipelineErrors");

        /* Create a CloudEvent from a pipelineRunFinishedCDEvent */
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(pipelineRunFinishedCDEvent);

        /* This CDEvent can be sent as CloudEvent using HTTP Protocol Binding,
            Refer : https://cloudevents.github.io/sdk-java/http-basic.html
         */

    }
}
```
Now the CDEvent can be sent as CloudEvent using [Generic HTTP Protocol Binding](https://cloudevents.github.io/sdk-java/http-basic.html)

## Contributing

If you would like to contribute, see our [development](DEVELOPMENT.md) guide.

## References

- [CDEvents](https://cdevents.dev)
- [CDFoundation SIG Events Vocabulary Draft](https://github.com/cdfoundation/sig-events/tree/main/vocabulary-draft)
