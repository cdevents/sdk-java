package dev.cdevents;

import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.events.PipelineRunFinishedCDEvent;
import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
public class CDEventsTest {

    @Test
    void createPipelineRunFinishedEventAsCloudEvent() {

        PipelineRunFinishedCDEvent cdEvent =  new PipelineRunFinishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));
        cdEvent.setSubjectId("/dev/pipeline/run/subject");
        cdEvent.setSubjectSource(URI.create("/dev/pipeline/run/subject"));
        cdEvent.setSubjectPipelineName("Name-pipeline");
        cdEvent.setSubjectUrl(URI.create("http://dev/pipeline/url"));
        cdEvent.setSubjectErrors("errors to place");
        cdEvent.setSubjectOutcome(CDEventConstants.Outcome.SUCCESS);

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType());
        assertThat(ceEvent.getSource()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }
}
