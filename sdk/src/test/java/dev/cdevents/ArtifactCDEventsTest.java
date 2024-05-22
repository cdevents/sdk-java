package dev.cdevents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.packageurl.MalformedPackageURLException;
import dev.cdevents.config.CustomObjectMapper;
import dev.cdevents.events.*;
import dev.cdevents.exception.CDEventsException;
import io.cloudevents.CloudEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArtifactCDEventsTest {

    private static final ObjectMapper objectMapper = new CustomObjectMapper().customConfiguration();

    @Test
    void createArtifactDeletedEventAsCloudEvent() {

        ArtifactDeletedCDEvent cdEvent =  new ArtifactDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));
        cdEvent.setSubjectUser("testUser");


        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createArtifactDownloadedEventAsCloudEvent() {

        ArtifactDownloadedCDEvent cdEvent =  new ArtifactDownloadedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));
        cdEvent.setSubjectUser("testUser");


        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createArtifactPackagedEventAsCloudEvent() throws MalformedPackageURLException {

        ArtifactPackagedCDEvent cdEvent =  new ArtifactPackagedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));

        cdEvent.setSubjectChangeId("test-feature");
        cdEvent.setSubjectChangeSource("/github.com/test-repo");
        cdEvent.setSubjectSbomUri("https://sbom.storage.service/my-projects/3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427.sbom");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void createArtifactPublishedEventAsCloudEvent() throws MalformedPackageURLException {
        ArtifactPublishedCDEvent cdEvent = new ArtifactPublishedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));
        cdEvent.setSubjectSbomUri("https://sbom.storage.service/my-projects/3A0b31b1c02ff458ad9b7b81cbdf8f028bd54699fa151f221d1e8de6817db93427.sbom");

        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);

    }

    @Test
    void createArtifactSignedEventAsCloudEvent() {

        ArtifactSignedCDEvent cdEvent =  new ArtifactSignedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        cdEvent.setSubjectId("pkg:oci/myapp@sha256%3A0b31b1c02ff458ad9b7b");
        cdEvent.setSubjectSource(URI.create("/dev/artifact/source"));
        cdEvent.setSubjectSignature("SHA-MEYCIQCBT8U5ypDXWCjlNKfzTV4KH516");


        String cdEventJson = CDEvents.cdEventAsJson(cdEvent);

        CloudEvent ceEvent = CDEvents.cdEventAsCloudEvent(cdEvent);

        String ceDataJson = new String(ceEvent.getData().toBytes(), StandardCharsets.UTF_8);

        assertThat(ceEvent.getType()).isEqualTo(cdEvent.getContext().getType().value());
        assertThat(ceEvent.getSource().toString()).isEqualTo(cdEvent.getContext().getSource());
        assertThat(ceDataJson).isEqualTo(cdEventJson);
    }

    @Test
    void testInvalidArtifactDeletedEventWithNoSubject() {
        ArtifactDeletedCDEvent cdEvent =  new ArtifactDeletedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidArtifactDownloadedEventWithNoSubject() {
        ArtifactDownloadedCDEvent cdEvent =  new ArtifactDownloadedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidArtifactPackagedEventWithNoSubject() {
        ArtifactPackagedCDEvent cdEvent =  new ArtifactPackagedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidArtifactPublishedEventWithNoSubject() {
        ArtifactPublishedCDEvent cdEvent =  new ArtifactPublishedCDEvent();

        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidArtifactSignedEventWithNoSubject() {
        ArtifactSignedCDEvent cdEvent =  new ArtifactSignedCDEvent();
        cdEvent.setSource(URI.create("http://dev.cdevents"));

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventAsCloudEvent(cdEvent);
        });
        String expectedError = "CDEvent validation failed against schema URL - " + cdEvent.schemaURL();

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidArtifactPackagedEventJson() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/artifact_packaged_with_no_content.json");
        JsonNode expectedNode = objectMapper.readTree(inputStream);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventFromJson(expectedJson);
        });
        String expectedError = "CDEvent Json validation failed against schema";

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

    @Test
    void testInvalidArtifactPublishedEventJson() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/artifact_published_with_no_context.json");
        JsonNode expectedNode = objectMapper.readTree(inputStream);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventFromJson(expectedJson);
        });
        String expectedError = "Unable to find context and type in CDEvent Json";

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }
    @Test
    void testInvalidArtifactSignedEventJson() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/artifact_signed_with_invalid_type.json");
        JsonNode expectedNode = objectMapper.readTree(inputStream);
        String expectedJson = objectMapper.writeValueAsString(expectedNode);

        Exception exception = assertThrows(CDEventsException.class, () -> {
            CDEvents.cdEventFromJson(expectedJson);
        });
        String expectedError = "Invalid CDEvent type found from cdEventJson";

        assertThat(exception.getMessage()).isEqualTo(expectedError);
    }

}
