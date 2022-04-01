package dev.cdevents;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.v03.CloudEventBuilder;

public final class CDEventTypes {

    private CDEventTypes() {
    }

    /**
     * Creates a continuous delivery Pipeline run events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param pipelineRunEventType
     * @param pipelineRunId
     * @param pipelineRunName
     * @param pipelineRunStatus
     * @param pipelineRunURL
     * @param pipelineRunErrors
     * @param pipelineRunData
     * @return the cloudEvent object with continuous delivery
     * Pipeline run event extensions
     */
    public static CloudEvent createPipelineRunEvent(
            final String pipelineRunEventType,
            final String pipelineRunId, final String pipelineRunName,
            final String pipelineRunStatus, final String pipelineRunURL,
            final String pipelineRunErrors, final String pipelineRunData) {
        CloudEvent ceToSend =
                buildCloudEvent(pipelineRunEventType, pipelineRunData)
                .withExtension("pipelinerunid", pipelineRunId)
                .withExtension("pipelinerunname", pipelineRunName)
                .withExtension("pipelinerunstatus", pipelineRunStatus)
                .withExtension("pipelinerunurl", pipelineRunURL)
                .withExtension("pipelinerunerrors", pipelineRunErrors)
                .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery Task run events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param taskRunEventType
     * @param taskRunId
     * @param taskRunName
     * @param taskRunPipelineId
     * @param taskRunData
     * @return the cloudEvent object with continuous delivery
     * task run event extensions
     */
    public static CloudEvent createTaskRunEvent(
            final String taskRunEventType, final String taskRunId,
            final String taskRunName, final String taskRunPipelineId,
            final String taskRunData) {
        CloudEvent ceToSend =
                buildCloudEvent(taskRunEventType, taskRunData)
                .withExtension("taskrunid", taskRunId)
                .withExtension("taskrunname", taskRunName)
                .withExtension("taskrunpipelineid", taskRunPipelineId)
                .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery repository events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param repositoryEventType
     * @param repositoryId
     * @param repositoryName
     * @param repositoryURL
     * @param repositoryData
     * @return the cloudEvent object with continuous delivery
     * repository event extensions
     */
    public static CloudEvent createRepositoryEvent(
            final String repositoryEventType, final String repositoryId,
            final String repositoryName, final String repositoryURL,
            final String repositoryData) {
        CloudEvent ceToSend =
                buildCloudEvent(repositoryEventType, repositoryData)
                .withExtension("repositoryid", repositoryId)
                .withExtension("repositoryname", repositoryName)
                .withExtension("repositoryurl", repositoryURL)
                .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery build events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param buildEventType
     * @param buildId
     * @param buildName
     * @param buildArtifactId
     * @param buildData
     * @return the cloudEvent object with continuous delivery
     * build event extensions
     */
    public static CloudEvent createBuildEvent(
            final String buildEventType, final String buildId,
            final String buildName, final String buildArtifactId,
            final String buildData) {
        CloudEvent ceToSend =
                buildCloudEvent(buildEventType, buildData)
                .withExtension("buildid", buildId)
                .withExtension("buildname", buildName)
                .withExtension("buildartifactid", buildArtifactId)
                .build();
        return ceToSend;
    }

    /**
     *  Creates a continuous delivery test events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param testEventType
     * @param testId
     * @param testName
     * @param testVersion
     * @param testData
     * @return the cloudEvent object with continuous delivery
     * test event extensions
     */
    public static CloudEvent createTestEvent(
            final String testEventType, final String testId,
            final String testName, final String testVersion,
            final String testData) {
        CloudEvent ceToSend =
                buildCloudEvent(testEventType, testData)
                .withExtension("testid", testId)
                .withExtension("testname", testName)
                .withExtension("testversion", testVersion)
                .build();
        return ceToSend;
    }

    /**
     *  Creates a continuous delivery artifact events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param artifactEventType
     * @param artifactId
     * @param artifactName
     * @param artifactVersion
     * @param artifactData
     * @return the cloudEvent object with continuous delivery
     * artifact event extensions
     */
    public static CloudEvent createArtifactEvent(
            final String artifactEventType, final String artifactId,
            final String artifactName,
            final String artifactVersion, final String artifactData) {
        CloudEvent ceToSend = buildCloudEvent(artifactEventType, artifactData)
                .withExtension("artifactid", artifactId)
                .withExtension("artifactname", artifactName)
                .withExtension("artifactversion", artifactVersion)
                .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery environment events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param envEventType
     * @param envId
     * @param envName
     * @param envRepoUrl
     * @param envData
     * @return the cloudEvent object with continuous delivery
     * environment event extensions
     */
    public static CloudEvent createEnvironmentEvent(
            final String envEventType, final String envId,
            final String envName, final  String envRepoUrl,
            final String envData) {
        CloudEvent ceToSend =
                buildCloudEvent(envEventType, envData)
                .withExtension("envid", envId)
                .withExtension("envname", envName)
                .withExtension("envrepourl", envRepoUrl)
                .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery service events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param serviceEventType
     * @param serviceId
     * @param serviceName
     * @param serviceVersion
     * @param serviceData
     * @return the cloudEvent object with continuous delivery
     * service event extensions
     */
    public static CloudEvent createServiceEvent(
            final String serviceEventType, final String serviceId,
            final String serviceName, final String serviceVersion,
            final String serviceData) {
        CloudEvent ceToSend =
                buildCloudEvent(serviceEventType, serviceData)
                .withExtension("serviceid", serviceId)
                .withExtension("servicename", serviceName)
                .withExtension("serviceversion", serviceVersion)
                .build();
        return ceToSend;
    }

    private static CloudEventBuilder buildCloudEvent(
            final String eventType, final String eventData) {
        CloudEventBuilder ceBuilder = new CloudEventBuilder()
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create("cdevents-sdk-java"))
                .withType(eventType)
                .withData(eventData.getBytes(StandardCharsets.UTF_8))
                .withTime(OffsetDateTime.now());
        return ceBuilder;
    }
}
