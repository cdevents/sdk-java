package dev.cdevents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.events.*;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.testcaserun.finished.Content;
import dev.cdevents.models.testcaserun.finished.TestCase;
import dev.cdevents.models.testcaserun.queued.Trigger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDEventsSpecExamplesTest {

    private static String EXAMPLES_FOLDER = CDEventConstants.SPEC_REPO + File.separator + "conformance";
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testArtifactDeletedCDEvent() throws IOException {

        File artifactDeletedExample = new File(EXAMPLES_FOLDER + File.separator + "artifact_deleted.json");
        JsonNode expectedNode = objectMapper.readTree(artifactDeletedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ArtifactDeletedCDEvent expectedEvent = (ArtifactDeletedCDEvent) expectedCDEvent;

        ArtifactDeletedCDEvent createdEvent =  new ArtifactDeletedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("pkg:golang/mygit.com/myorg/myapp@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectUser("mybot-myapp");


        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testArtifactDownloadedCDEvent() throws IOException {

        File artifactDownloadedExample = new File(EXAMPLES_FOLDER + File.separator + "artifact_downloaded.json");
        JsonNode expectedNode = objectMapper.readTree(artifactDownloadedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ArtifactDownloadedCDEvent expectedEvent = (ArtifactDownloadedCDEvent) expectedCDEvent;

        ArtifactDownloadedCDEvent createdEvent =  new ArtifactDownloadedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("pkg:golang/mygit.com/myorg/myapp@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectUser("mybot-myapp");


        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testArtifactPackagedCDEvent() throws IOException {

        File artifactPackagedExample = new File(EXAMPLES_FOLDER + File.separator + "artifact_packaged.json");
        JsonNode expectedNode = objectMapper.readTree(artifactPackagedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ArtifactPackagedCDEvent expectedEvent = (ArtifactPackagedCDEvent) expectedCDEvent;

        ArtifactPackagedCDEvent createdEvent =  new ArtifactPackagedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("pkg:golang/mygit.com/myorg/myapp@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectChangeId("myChange123");
        createdEvent.setSubjectChangeSource("my-git.example/an-org/a-repo");
        createdEvent.setSubjectSbomUri("https://sbom.repo/myorg/234fd47e07d1004f0aed9c.sbom");

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
    @Test
    void testArtifactPublishedCDEvent() throws IOException {

        File artifactPublishedExample = new File(EXAMPLES_FOLDER + File.separator + "artifact_published.json");
        JsonNode expectedNode = objectMapper.readTree(artifactPublishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ArtifactPublishedCDEvent expectedEvent = (ArtifactPublishedCDEvent) expectedCDEvent;

        ArtifactPublishedCDEvent createdEvent =  new ArtifactPublishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("pkg:golang/mygit.com/myorg/myapp@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectSbomUri("https://sbom.repo/myorg/234fd47e07d1004f0aed9c.sbom");
        createdEvent.setSubjectUser("mybot-myapp");

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testArtifactSignedCDEvent() throws IOException {

        File artifactSignedExample = new File(EXAMPLES_FOLDER + File.separator + "artifact_signed.json");
        JsonNode expectedNode = objectMapper.readTree(artifactSignedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ArtifactSignedCDEvent expectedEvent = (ArtifactSignedCDEvent) expectedCDEvent;

        ArtifactSignedCDEvent createdEvent =  new ArtifactSignedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("pkg:golang/mygit.com/myorg/myapp@234fd47e07d1004f0aed9c");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectSignature("MEYCIQCBT8U5ypDXWCjlNKfzTV4KH516/SK13NZSh8znnSMNkQIhAJ3XiQlc9PM1KyjITcZXHotdMB+J3NGua5T/yshmiPmp");

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testBranchCreatedCDEvent() throws IOException {

        File branchCreatedExample = new File(EXAMPLES_FOLDER + File.separator + "branch_created.json");
        JsonNode expectedNode = objectMapper.readTree(branchCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        BranchCreatedCDEvent expectedEvent = (BranchCreatedCDEvent) expectedCDEvent;

        BranchCreatedCDEvent createdEvent =  new BranchCreatedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testBranchDeletedCDEvent() throws IOException {

        File branchDeletedExample = new File(EXAMPLES_FOLDER + File.separator + "branch_deleted.json");
        JsonNode expectedNode = objectMapper.readTree(branchDeletedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        BranchDeletedCDEvent expectedEvent = (BranchDeletedCDEvent) expectedCDEvent;

        BranchDeletedCDEvent createdEvent =  new BranchDeletedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
    @Test
    void testBuildFinishedCDEvent() throws IOException {

        File buildFinishedExample = new File(EXAMPLES_FOLDER + File.separator + "build_finished.json");
        JsonNode expectedNode = objectMapper.readTree(buildFinishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        BuildFinishedCDEvent expectedEvent = (BuildFinishedCDEvent) expectedCDEvent;

        BuildFinishedCDEvent createdEvent =  new BuildFinishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427");

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testBuildQueuedCDEvent() throws IOException {

        File buildQueuedExample = new File(EXAMPLES_FOLDER + File.separator + "build_queued.json");
        JsonNode expectedNode = objectMapper.readTree(buildQueuedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        BuildQueuedCDEvent expectedEvent = (BuildQueuedCDEvent) expectedCDEvent;

        BuildQueuedCDEvent createdEvent =  new BuildQueuedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));

        //replace context id, timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testBuildStartedCDEvent() throws IOException {

        File buildStartedExample = new File(EXAMPLES_FOLDER + File.separator + "build_started.json");
        JsonNode expectedNode = objectMapper.readTree(buildStartedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        BuildStartedCDEvent expectedEvent = (BuildStartedCDEvent) expectedCDEvent;

        BuildStartedCDEvent createdEvent =  new BuildStartedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testChangeAbandonedCDEvent() throws IOException {

        File changeAbandonedExample = new File(EXAMPLES_FOLDER + File.separator + "change_abandoned.json");
        JsonNode expectedNode = objectMapper.readTree(changeAbandonedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ChangeAbandonedCDEvent expectedEvent = (ChangeAbandonedCDEvent) expectedCDEvent;

        ChangeAbandonedCDEvent createdEvent =  new ChangeAbandonedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testChangeCreatedCDEvent() throws IOException {

        File changeCreatedExample = new File(EXAMPLES_FOLDER + File.separator + "change_created.json");
        JsonNode expectedNode = objectMapper.readTree(changeCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ChangeCreatedCDEvent expectedEvent = (ChangeCreatedCDEvent) expectedCDEvent;

        ChangeCreatedCDEvent createdEvent =  new ChangeCreatedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectDescription("This PR address a bug from a recent PR");
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testChangeMergedCDEvent() throws IOException {

        File changeMergedExample = new File(EXAMPLES_FOLDER + File.separator + "change_merged.json");
        JsonNode expectedNode = objectMapper.readTree(changeMergedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ChangeMergedCDEvent expectedEvent = (ChangeMergedCDEvent) expectedCDEvent;

        ChangeMergedCDEvent createdEvent =  new ChangeMergedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testChangeReviewedCDEvent() throws IOException {

        File changeReviewedExample = new File(EXAMPLES_FOLDER + File.separator + "change_reviewed.json");
        JsonNode expectedNode = objectMapper.readTree(changeReviewedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ChangeReviewedCDEvent expectedEvent = (ChangeReviewedCDEvent) expectedCDEvent;

        ChangeReviewedCDEvent createdEvent =  new ChangeReviewedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testChangeUpdatedCDEvent() throws IOException {

        File changeUpdatedExample = new File(EXAMPLES_FOLDER + File.separator + "change_updated.json");
        JsonNode expectedNode = objectMapper.readTree(changeUpdatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ChangeUpdatedCDEvent expectedEvent = (ChangeUpdatedCDEvent) expectedCDEvent;

        ChangeUpdatedCDEvent createdEvent =  new ChangeUpdatedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectRepositoryId("TestRepo/TestOrg");
        createdEvent.setSubjectRepositorySource("https://example.org");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testEnvironmentCreatedCDEvent() throws IOException {

        File environmentCreatedExample = new File(EXAMPLES_FOLDER + File.separator + "environment_created.json");
        JsonNode expectedNode = objectMapper.readTree(environmentCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        EnvironmentCreatedCDEvent expectedEvent = (EnvironmentCreatedCDEvent) expectedCDEvent;

        EnvironmentCreatedCDEvent createdEvent =  new EnvironmentCreatedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectName("testEnv");
        createdEvent.setSubjectUrl("https://example.org/testEnv");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testEnvironmentDeletedCDEvent() throws IOException {

        File environmentDeletedExample = new File(EXAMPLES_FOLDER + File.separator + "environment_deleted.json");
        JsonNode expectedNode = objectMapper.readTree(environmentDeletedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        EnvironmentDeletedCDEvent expectedEvent = (EnvironmentDeletedCDEvent) expectedCDEvent;

        EnvironmentDeletedCDEvent createdEvent =  new EnvironmentDeletedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectName("testEnv");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testEnvironmentModifiedCDEvent() throws IOException {

        File environmentModifiedExample = new File(EXAMPLES_FOLDER + File.separator + "environment_modified.json");
        JsonNode expectedNode = objectMapper.readTree(environmentModifiedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        EnvironmentModifiedCDEvent expectedEvent = (EnvironmentModifiedCDEvent) expectedCDEvent;

        EnvironmentModifiedCDEvent createdEvent =  new EnvironmentModifiedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectName("testEnv");
        createdEvent.setSubjectUrl("https://example.org/testEnv");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testIncidentDetectedCDEvent() throws IOException {

        File incidentDetectedExample = new File(EXAMPLES_FOLDER + File.separator + "incident_detected.json");
        JsonNode expectedNode = objectMapper.readTree(incidentDetectedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        IncidentDetectedCDEvent expectedEvent = (IncidentDetectedCDEvent) expectedCDEvent;

        IncidentDetectedCDEvent createdEvent =  new IncidentDetectedCDEvent();
        createdEvent.setSource(URI.create("/monitoring/prod1"));
        createdEvent.setSubjectId("incident-123");
        createdEvent.setSubjectSource(URI.create("/monitoring/prod1"));
        createdEvent.setSubjectDescription("Response time above threshold of 100ms");
        createdEvent.setSubjectEnvironmentId("prod1");
        createdEvent.setSubjectEnvironmentSource("/iaas/geo1");
        createdEvent.setSubjectServiceId("myApp");
        createdEvent.setSubjectServiceSource("/clusterA/namespaceB");
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427");
        Map<String,String> customMap = new HashMap<>();
        customMap.put("metric", "responseTime");
        customMap.put("threshold", "100ms");
        customMap.put("value", "200ms");
        createdEvent.setCustomData(customMap);

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
        assertEquals(expectedEvent.getCustomData(), createdEvent.getCustomData());
        assertEquals(expectedEvent.getCustomDataContentType(), createdEvent.getCustomDataContentType());
    }

    @Test
    void testIncidentReportedCDEvent() throws IOException {

        File incidentReportedExample = new File(EXAMPLES_FOLDER + File.separator + "incident_reported.json");
        JsonNode expectedNode = objectMapper.readTree(incidentReportedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        IncidentReportedCDEvent expectedEvent = (IncidentReportedCDEvent) expectedCDEvent;

        IncidentReportedCDEvent createdEvent =  new IncidentReportedCDEvent();
        createdEvent.setSource(URI.create("/monitoring/prod1"));
        createdEvent.setSubjectId("incident-123");
        createdEvent.setSubjectSource(URI.create("/monitoring/prod1"));
        createdEvent.setSubjectDescription("Response time above threshold of 100ms");
        createdEvent.setSubjectEnvironmentId("prod1");
        createdEvent.setSubjectEnvironmentSource("/iaas/geo1");
        createdEvent.setSubjectServiceId("myApp");
        createdEvent.setSubjectServiceSource("/clusterA/namespaceB");
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427");
        createdEvent.setSubjectTicketURI(URI.create("https://my-issues.example/incidents/ticket-345"));
        Map<String,String> customMap = new HashMap<>();
        customMap.put("severity", "medium");
        customMap.put("priority", "critical");
        customMap.put("reportedBy", "userId");
        createdEvent.setCustomData(customMap);

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
        assertEquals(expectedEvent.getCustomData(), createdEvent.getCustomData());
        assertEquals(expectedEvent.getCustomDataContentType(), createdEvent.getCustomDataContentType());
    }

    @Test
    void testIncidentResolvedCDEvent() throws IOException {

        File incidentResolvedExample = new File(EXAMPLES_FOLDER + File.separator + "incident_resolved.json");
        JsonNode expectedNode = objectMapper.readTree(incidentResolvedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        IncidentResolvedCDEvent expectedEvent = (IncidentResolvedCDEvent) expectedCDEvent;

        IncidentResolvedCDEvent createdEvent =  new IncidentResolvedCDEvent();
        createdEvent.setSource(URI.create("/monitoring/prod1"));
        createdEvent.setSubjectId("incident-123");
        createdEvent.setSubjectSource(URI.create("/monitoring/prod1"));
        createdEvent.setSubjectDescription("Response time restored below 100ms");
        createdEvent.setSubjectEnvironmentId("prod1");
        createdEvent.setSubjectEnvironmentSource("/iaas/geo1");
        createdEvent.setSubjectServiceId("myApp");
        createdEvent.setSubjectServiceSource("/clusterA/namespaceB");
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93439");
        Map<String,String> customMap = new HashMap<>();
        customMap.put("metric", "responseTime");
        customMap.put("threshold", "100ms");
        customMap.put("value", "70ms");
        createdEvent.setCustomData(customMap);

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
        assertEquals(expectedEvent.getCustomData(), createdEvent.getCustomData());
        assertEquals(expectedEvent.getCustomDataContentType(), createdEvent.getCustomDataContentType());
    }

    @Test
    void testPipelinerunFinishedCDEvent() throws IOException {

        File pipelinerunFinishedExample = new File(EXAMPLES_FOLDER + File.separator + "pipelinerun_finished.json");
        JsonNode expectedNode = objectMapper.readTree(pipelinerunFinishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        PipelinerunFinishedCDEvent expectedEvent = (PipelinerunFinishedCDEvent) expectedCDEvent;

        PipelinerunFinishedCDEvent createdEvent =  new PipelinerunFinishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectPipelineName("myPipeline");
        createdEvent.setSubjectUrl("https://www.example.com/mySubject123");
        createdEvent.setSubjectOutcome("failure");
        createdEvent.setSubjectErrors("Something went wrong\nWith some more details");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testPipelinerunQueuedCDEvent() throws IOException {

        File pipelinerunQueuedExample = new File(EXAMPLES_FOLDER + File.separator + "pipelinerun_queued.json");
        JsonNode expectedNode = objectMapper.readTree(pipelinerunQueuedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        PipelinerunQueuedCDEvent expectedEvent = (PipelinerunQueuedCDEvent) expectedCDEvent;

        PipelinerunQueuedCDEvent createdEvent =  new PipelinerunQueuedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectPipelineName("myPipeline");
        createdEvent.setSubjectUrl("https://www.example.com/mySubject123");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
    @Test
    void testPipelinerunStartedCDEvent() throws IOException {

        File pipelinerunStartedExample = new File(EXAMPLES_FOLDER + File.separator + "pipelinerun_started.json");
        JsonNode expectedNode = objectMapper.readTree(pipelinerunStartedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        PipelinerunStartedCDEvent expectedEvent = (PipelinerunStartedCDEvent) expectedCDEvent;

        PipelinerunStartedCDEvent createdEvent =  new PipelinerunStartedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectPipelineName("myPipeline");
        createdEvent.setSubjectUrl("https://www.example.com/mySubject123");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testRepositoryCreatedCDEvent() throws IOException {

        File repositoryCreatedExample = new File(EXAMPLES_FOLDER + File.separator + "repository_created.json");
        JsonNode expectedNode = objectMapper.readTree(repositoryCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        RepositoryCreatedCDEvent expectedEvent = (RepositoryCreatedCDEvent) expectedCDEvent;

        RepositoryCreatedCDEvent createdEvent =  new RepositoryCreatedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectName("TestRepo");
        createdEvent.setSubjectOwner("TestOrg");
        createdEvent.setSubjectUrl("https://example.org/TestOrg/TestRepo");
        createdEvent.setSubjectViewUrl("https://example.org/view/TestOrg/TestRepo");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testRepositoryDeletedCDEvent() throws IOException {

        File repositoryDeletedExample = new File(EXAMPLES_FOLDER + File.separator + "repository_deleted.json");
        JsonNode expectedNode = objectMapper.readTree(repositoryDeletedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        RepositoryDeletedCDEvent expectedEvent = (RepositoryDeletedCDEvent) expectedCDEvent;

        RepositoryDeletedCDEvent createdEvent =  new RepositoryDeletedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectName("TestRepo");
        createdEvent.setSubjectOwner("TestOrg");
        createdEvent.setSubjectUrl("https://example.org/TestOrg/TestRepo");
        createdEvent.setSubjectViewUrl("https://example.org/view/TestOrg/TestRepo");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
    @Test
    void testRepositoryModifiedCDEvent() throws IOException {

        File repositoryModifiedExample = new File(EXAMPLES_FOLDER + File.separator + "repository_modified.json");
        JsonNode expectedNode = objectMapper.readTree(repositoryModifiedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        RepositoryModifiedCDEvent expectedEvent = (RepositoryModifiedCDEvent) expectedCDEvent;

        RepositoryModifiedCDEvent createdEvent =  new RepositoryModifiedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectName("TestRepo");
        createdEvent.setSubjectOwner("TestOrg");
        createdEvent.setSubjectUrl("https://example.org/TestOrg/TestRepo");
        createdEvent.setSubjectViewUrl("https://example.org/view/TestOrg/TestRepo");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testServiceDeployedCDEvent() throws IOException {

        File serviceDeployedExample = new File(EXAMPLES_FOLDER + File.separator + "service_deployed.json");
        JsonNode expectedNode = objectMapper.readTree(serviceDeployedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ServiceDeployedCDEvent expectedEvent = (ServiceDeployedCDEvent) expectedCDEvent;

        ServiceDeployedCDEvent createdEvent =  new ServiceDeployedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("test123");
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
    @Test
    void testServicePublishedCDEvent() throws IOException {

        File servicePublishedExample = new File(EXAMPLES_FOLDER + File.separator + "service_published.json");
        JsonNode expectedNode = objectMapper.readTree(servicePublishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ServicePublishedCDEvent expectedEvent = (ServicePublishedCDEvent) expectedCDEvent;

        ServicePublishedCDEvent createdEvent =  new ServicePublishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("test123");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testServiceRemovedCDEvent() throws IOException {

        File serviceRemovedExample = new File(EXAMPLES_FOLDER + File.separator + "service_removed.json");
        JsonNode expectedNode = objectMapper.readTree(serviceRemovedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ServiceRemovedCDEvent expectedEvent = (ServiceRemovedCDEvent) expectedCDEvent;

        ServiceRemovedCDEvent createdEvent =  new ServiceRemovedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("test123");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testServiceRolledbackCDEvent() throws IOException {

        File serviceRolledbackExample = new File(EXAMPLES_FOLDER + File.separator + "service_rolledback.json");
        JsonNode expectedNode = objectMapper.readTree(serviceRolledbackExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ServiceRolledbackCDEvent expectedEvent = (ServiceRolledbackCDEvent) expectedCDEvent;

        ServiceRolledbackCDEvent createdEvent =  new ServiceRolledbackCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("test123");
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testServiceUpgradedCDEvent() throws IOException {

        File serviceUpgradedExample = new File(EXAMPLES_FOLDER + File.separator + "service_upgraded.json");
        JsonNode expectedNode = objectMapper.readTree(serviceUpgradedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        ServiceUpgradedCDEvent expectedEvent = (ServiceUpgradedCDEvent) expectedCDEvent;

        ServiceUpgradedCDEvent createdEvent =  new ServiceUpgradedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("test123");
        createdEvent.setSubjectArtifactId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTaskrunFinishedCDEvent() throws IOException {

        File taskrunFinishedExample = new File(EXAMPLES_FOLDER + File.separator + "taskrun_finished.json");
        JsonNode expectedNode = objectMapper.readTree(taskrunFinishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TaskrunFinishedCDEvent expectedEvent = (TaskrunFinishedCDEvent) expectedCDEvent;

        TaskrunFinishedCDEvent createdEvent =  new TaskrunFinishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectTaskName("myTask");
        createdEvent.setSubjectUrl("https://www.example.com/mySubject123");
        createdEvent.setSubjectPipelineRunId("mySubject123");
        createdEvent.setSubjectOutcome("failure");
        createdEvent.setSubjectErrors("Something went wrong\nWith some more details");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTaskrunStartedCDEvent() throws IOException {

        File taskrunStartedExample = new File(EXAMPLES_FOLDER + File.separator + "taskrun_started.json");
        JsonNode expectedNode = objectMapper.readTree(taskrunStartedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TaskrunStartedCDEvent expectedEvent = (TaskrunStartedCDEvent) expectedCDEvent;

        TaskrunStartedCDEvent createdEvent =  new TaskrunStartedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("mySubject123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectTaskName("myTask");
        createdEvent.setSubjectUrl("https://www.example.com/mySubject123");
        createdEvent.setSubjectPipelineRunId("mySubject123");

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTestcaserunFinishedCDEvent() throws IOException {

        File testcaserunFinishedExample = new File(EXAMPLES_FOLDER + File.separator + "testcaserun_finished.json");
        JsonNode expectedNode = objectMapper.readTree(testcaserunFinishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestcaserunFinishedCDEvent expectedEvent = (TestcaserunFinishedCDEvent) expectedCDEvent;

        TestcaserunFinishedCDEvent createdEvent =  new TestcaserunFinishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestCaseRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectOutcome(Content.Outcome.PASS);
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestCaseId("92834723894");
        createdEvent.setSubjectTestCaseVersion("1.0");
        createdEvent.setSubjectTestCaseName("Login Test");
        createdEvent.setSubjectTestCaseType(TestCase.Type.INTEGRATION);
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject().getContent().getOutcome(), createdEvent.getSubject().getContent().getOutcome());
        assertEquals(expectedEvent.getSubject().getContent().getTestCase(), createdEvent.getSubject().getContent().getTestCase());
        assertEquals(expectedEvent.getSubject().getContent().getEnvironment(), createdEvent.getSubject().getContent().getEnvironment());
    }

    @Test
    void testTestcaserunQueuedCDEvent() throws IOException {

        File testcaserunQueuedExample = new File(EXAMPLES_FOLDER + File.separator + "testcaserun_queued.json");
        JsonNode expectedNode = objectMapper.readTree(testcaserunQueuedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestcaserunQueuedCDEvent expectedEvent = (TestcaserunQueuedCDEvent) expectedCDEvent;

        TestcaserunQueuedCDEvent createdEvent =  new TestcaserunQueuedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestCaseRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestCaseId("92834723894");
        createdEvent.setSubjectTestCaseVersion("1.0");
        createdEvent.setSubjectTestCaseName("Login Test");
        createdEvent.setSubjectTestCaseType(dev.cdevents.models.testcaserun.queued.TestCase.Type.INTEGRATION);
        createdEvent.setSubjectTriggerType(Trigger.Type.SCHEDULE);

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject().getContent().getTrigger(), createdEvent.getSubject().getContent().getTrigger());
        assertEquals(expectedEvent.getSubject().getContent().getTestCase(), createdEvent.getSubject().getContent().getTestCase());
        assertEquals(expectedEvent.getSubject().getContent().getEnvironment(), createdEvent.getSubject().getContent().getEnvironment());
    }

    @Test
    void testTestcaserunSkippedCDEvent() throws IOException {

        File testcaserunSkippedExample = new File(EXAMPLES_FOLDER + File.separator + "testcaserun_skipped.json");
        JsonNode expectedNode = objectMapper.readTree(testcaserunSkippedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestcaserunSkippedCDEvent expectedEvent = (TestcaserunSkippedCDEvent) expectedCDEvent;

        TestcaserunSkippedCDEvent createdEvent =  new TestcaserunSkippedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestCaseRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectReason("Not running in this environment");
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestSuiteRunId("test-suite-111");
        createdEvent.setSubjectTestSuiteRunSource("testkube-dev-123");
        createdEvent.setSubjectTestCaseId("92834723894");
        createdEvent.setSubjectTestCaseVersion("1.0");
        createdEvent.setSubjectTestCaseName("Login Test");
        createdEvent.setSubjectTestCaseType(dev.cdevents.models.testcaserun.skipped.TestCase.Type.INTEGRATION);

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject().getContent().getReason(), createdEvent.getSubject().getContent().getReason());
        assertEquals(expectedEvent.getSubject().getContent().getTestCase(), createdEvent.getSubject().getContent().getTestCase());
        assertEquals(expectedEvent.getSubject().getContent().getTestSuiteRun(), createdEvent.getSubject().getContent().getTestSuiteRun());
        assertEquals(expectedEvent.getSubject().getContent().getEnvironment(), createdEvent.getSubject().getContent().getEnvironment());
    }

    @Test
    void testTestcaserunStartedCDEvent() throws IOException {

        File testcaserunStartedExample = new File(EXAMPLES_FOLDER + File.separator + "testcaserun_started.json");
        JsonNode expectedNode = objectMapper.readTree(testcaserunStartedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestcaserunStartedCDEvent expectedEvent = (TestcaserunStartedCDEvent) expectedCDEvent;

        TestcaserunStartedCDEvent createdEvent =  new TestcaserunStartedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestCaseRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestCaseId("92834723894");
        createdEvent.setSubjectTestCaseVersion("1.0");
        createdEvent.setSubjectTestCaseName("Login Test");
        createdEvent.setSubjectTestCaseType(dev.cdevents.models.testcaserun.started.TestCase.Type.INTEGRATION);
        createdEvent.setSubjectTriggerType(dev.cdevents.models.testcaserun.started.Trigger.Type.SCHEDULE);

        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject().getContent().getTrigger(), createdEvent.getSubject().getContent().getTrigger());
        assertEquals(expectedEvent.getSubject().getContent().getTestCase(), createdEvent.getSubject().getContent().getTestCase());
        assertEquals(expectedEvent.getSubject().getContent().getEnvironment(), createdEvent.getSubject().getContent().getEnvironment());
    }

    @Test
    void testTestoutputPublishedCDEvent() throws IOException {

        File testoutputPublishedExample = new File(EXAMPLES_FOLDER + File.separator + "testoutput_published.json");
        JsonNode expectedNode = objectMapper.readTree(testoutputPublishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestoutputPublishedCDEvent expectedEvent = (TestoutputPublishedCDEvent) expectedCDEvent;

        TestoutputPublishedCDEvent createdEvent =  new TestoutputPublishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("testrunreport-12123");
        createdEvent.setSubjectSource(URI.create("/event/source/testrunreport-12123"));
        createdEvent.setSubjectOutputType(dev.cdevents.models.testoutput.published.Content.OutputType.VIDEO);
        createdEvent.setSubjectFormat("video/quicktime");
        createdEvent.setSubjectTestCaseRunId("myTestCaseRun123");
        createdEvent.setSubjectTestCaseRunSource("testkube-dev-123");


        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTestsuiterunFinishedCDEvent() throws IOException {

        File testsuiterunFinishedExample = new File(EXAMPLES_FOLDER + File.separator + "testsuiterun_finished.json");
        JsonNode expectedNode = objectMapper.readTree(testsuiterunFinishedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestsuiterunFinishedCDEvent expectedEvent = (TestsuiterunFinishedCDEvent) expectedCDEvent;

        TestsuiterunFinishedCDEvent createdEvent =  new TestsuiterunFinishedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestSuiteRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectOutcome(dev.cdevents.models.testsuiterun.finished.Content.Outcome.FAIL);
        createdEvent.setSubjectSeverity(dev.cdevents.models.testsuiterun.finished.Content.Severity.CRITICAL);
        createdEvent.setSubjectReason("Host 123.34.23.32 not found");
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestSuiteId("92834723894");
        createdEvent.setSubjectTestSuiteVersion("1.0");
        createdEvent.setSubjectTestSuiteName("Auth TestSuite");
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTestsuiterunQueuedCDEvent() throws IOException {

        File testsuiterunQueuedExample = new File(EXAMPLES_FOLDER + File.separator + "testsuiterun_queued.json");
        JsonNode expectedNode = objectMapper.readTree(testsuiterunQueuedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestsuiterunQueuedCDEvent expectedEvent = (TestsuiterunQueuedCDEvent) expectedCDEvent;

        TestsuiterunQueuedCDEvent createdEvent =  new TestsuiterunQueuedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestSuiteRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestSuiteId("92834723894");
        createdEvent.setSubjectTestSuiteVersion("1.0");
        createdEvent.setSubjectTestSuiteName("Auth TestSuite");
        createdEvent.setSubjectTriggerType(dev.cdevents.models.testsuiterun.queued.Trigger.Type.PIPELINE);
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTestsuiterunStartedCDEvent() throws IOException {

        File testsuiterunStartedExample = new File(EXAMPLES_FOLDER + File.separator + "testsuiterun_started.json");
        JsonNode expectedNode = objectMapper.readTree(testsuiterunStartedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TestsuiterunStartedCDEvent expectedEvent = (TestsuiterunStartedCDEvent) expectedCDEvent;

        TestsuiterunStartedCDEvent createdEvent =  new TestsuiterunStartedCDEvent();
        createdEvent.setSource(URI.create("/event/source/123"));
        createdEvent.setSubjectId("myTestSuiteRun123");
        createdEvent.setSubjectSource(URI.create("/event/source/123"));
        createdEvent.setSubjectEnvironmentId("dev");
        createdEvent.setSubjectEnvironmentSource("testkube-dev-123");
        createdEvent.setSubjectTestSuiteId("92834723894");
        createdEvent.setSubjectTestSuiteVersion("1.0");
        createdEvent.setSubjectTestSuiteName("Auth TestSuite");
        createdEvent.setSubjectTriggerType(dev.cdevents.models.testsuiterun.started.Trigger.Type.PIPELINE);
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK 
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTestTicketClosedCDEvent() throws IOException {

        File ticketClosedExample = new File(EXAMPLES_FOLDER + File.separator + "ticket_closed.json");
        JsonNode expectedNode = objectMapper.readTree(ticketClosedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TicketClosedCDEvent expectedEvent = (TicketClosedCDEvent) expectedCDEvent;

        TicketClosedCDEvent createdEvent =  new TicketClosedCDEvent();
        createdEvent.setSource(URI.create("/ticketing/system"));
        createdEvent.setSubjectId("ticket-123");
        createdEvent.setSubjectSource(URI.create("/ticketing/system"));
        createdEvent.setSubjectSummary("New CVE-123 detected");
        createdEvent.setSubjectTicketType("task");
        createdEvent.setSubjectGroup("security");
        createdEvent.setSubjectCreator("Alice");
        createdEvent.setSubjectAssignees(new ArrayList<>(Arrays.asList("Bob")));
        createdEvent.setSubjectPriority("high");
        createdEvent.setSubjectLabels(new ArrayList<>(Arrays.asList("bug")));
        createdEvent.setSubjectMilestone("123");
        createdEvent.setSubjectUri("https://example.issues.com/ticket123");
        createdEvent.setSubjectResolution("completed");
        createdEvent.setSubjectUpdatedBy("Bob");
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }

    @Test
    void testTestTicketCreatedCDEvent() throws IOException {

        File ticketCreatedExample = new File(EXAMPLES_FOLDER + File.separator + "ticket_created.json");
        JsonNode expectedNode = objectMapper.readTree(ticketCreatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TicketCreatedCDEvent expectedEvent = (TicketCreatedCDEvent) expectedCDEvent;

        TicketCreatedCDEvent createdEvent =  new TicketCreatedCDEvent();
        createdEvent.setSource(URI.create("/ticketing/system"));
        createdEvent.setSubjectId("ticket-123");
        createdEvent.setSubjectSource(URI.create("/ticketing/system"));
        createdEvent.setSubjectSummary("New CVE-123 detected");
        createdEvent.setSubjectTicketType("task");
        createdEvent.setSubjectGroup("security");
        createdEvent.setSubjectCreator("Alice");
        createdEvent.setSubjectAssignees(new ArrayList<>(Arrays.asList("Bob")));
        createdEvent.setSubjectPriority("high");
        createdEvent.setSubjectLabels(new ArrayList<>(Arrays.asList("bug")));
        createdEvent.setSubjectMilestone("123");
        createdEvent.setSubjectUri("https://example.issues.com/ticket123");
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
    @Test
    void testTestTicketUpdatedCDEvent() throws IOException {

        File ticketUpdatedExample = new File(EXAMPLES_FOLDER + File.separator + "ticket_updated.json");
        JsonNode expectedNode = objectMapper.readTree(ticketUpdatedExample);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);
        CDEvent expectedCDEvent = CDEvents.cdEventFromJson(expectedJson);
        TicketUpdatedCDEvent expectedEvent = (TicketUpdatedCDEvent) expectedCDEvent;

        TicketUpdatedCDEvent createdEvent =  new TicketUpdatedCDEvent();
        createdEvent.setSource(URI.create("/ticketing/system"));
        createdEvent.setSubjectId("ticket-123");
        createdEvent.setSubjectSource(URI.create("/ticketing/system"));
        createdEvent.setSubjectSummary("New CVE-123 detected");
        createdEvent.setSubjectTicketType("task");
        createdEvent.setSubjectGroup("security");
        createdEvent.setSubjectCreator("Alice");
        createdEvent.setSubjectAssignees(new ArrayList<>(Arrays.asList("Bob")));
        createdEvent.setSubjectPriority("high");
        createdEvent.setSubjectLabels(new ArrayList<>(Arrays.asList("bug")));
        createdEvent.setSubjectMilestone("123");
        createdEvent.setSubjectUri("https://example.issues.com/ticket123");
        createdEvent.setSubjectUpdatedBy("Bob");
        //replace createdEvent's context id and timestamp from the expectedEvent to compare objects directly
        createdEvent.getContext().setId(expectedEvent.getContext().getId());
        createdEvent.getContext().setTimestamp(expectedEvent.getContext().getTimestamp());

        //Uncomment Context validation once Links are implemented for SDK
//assertEquals(expectedEvent.getContext(), createdEvent.getContext());
        assertEquals(expectedEvent.getSubject(), createdEvent.getSubject());
    }
}
