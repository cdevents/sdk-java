# CDEvents Java SDK

Java SDK to produce [CDEvents](https://cdevents.dev).

The SDK can be used to create CDEvents and render as CloudEvents to send them to a specific CloudEvents broker

## Add dependency module

```xml
<dependency>
  <groupId>dev.cdevents</groupId>
  <artifactId>cdevents-sdk-java</artifactId>
  <version>${cdevents.version}</version>
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
        PipelinerunFinishedCDEvent pipelinerunFinishedCDEvent =  new PipelinerunFinishedCDEvent();

        /* set the required context fields to the pipelineRunFinishedCDEvent */
        pipelinerunFinishedCDEvent.setSource(URI.create("http://dev.cdevents"));

        /* set the required subject fields to the pipelineRunFinishedCDEvent */
        pipelinerunFinishedCDEvent.setSubjectId("/dev/pipeline/run/1");
        pipelinerunFinishedCDEvent.setSubjectSource(URI.create("http://dev.pipeline.run/source"));
        pipelinerunFinishedCDEvent.setSubjectUrl("http://dev.pipeline.run/url");
        pipelinerunFinishedCDEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS.getOutcome());
        pipelinerunFinishedCDEvent.setSubjectPipelineName("testPipeline");
        pipelinerunFinishedCDEvent.setSubjectErrors("pipelineErrors");

        /* Create a CloudEvent from a pipelineRunFinishedCDEvent */
        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(pipelinerunFinishedCDEvent);

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
- [CDEvents Primer](https://cdevents.dev/docs/primer/)
- [CDFoundation Specification](https://cdevents.dev/docs/)
