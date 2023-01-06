package dev.cdevents;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;

import dev.cdevents.constants.CDEventConstants;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.core.v03.CloudEventBuilder;
//import org.graalvm.compiler.nodes.calc.ObjectEqualsNode;

public final class CDEventTypes {

    private CDEventTypes() {
    }

    /**
     * Creates continuous delivery Pipeline run finished events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param pipelineName
     * @param url
     * @param errors
     * @param outcome
     * @return the cloudEvent object with continuous delivery
     * Pipeline run finished event extensions
     */


    public static CloudEvent createPipelineRunFinishedEvent(
            final String eventType,
            final String id, final URI source, final String pipelineName,
            final URI url, final CDEventConstants.Outcome outcome,
            final String errors, final String pipelineRunData) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, pipelineRunData)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("pipelinename", pipelineName)
                        .withExtension("url", url)
                        .withExtension("outcome", outcome.getOutcome())
                        .withExtension("errors", errors)
                        .build();
        return ceToSend;
    }

    /**
     * Creates continuous delivery Pipeline run queued events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param pipelineName
     * @param url
     * @return the cloudEvent object with continuous delivery
     * Pipeline run queued event extensions
     */


    public static CloudEvent createPipelineRunQueuedEvent(
            final String eventType,
            final String id, final URI source,
            final String pipelineName, final URI url,
            final String pipelineRunData){
        CloudEvent ceToSend =
                buildCloudEvent(eventType, pipelineRunData)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("pipelinename", pipelineName)
                        .withExtension("url", url)
                        .build();
        return ceToSend;
    }

    /**
     * Creates continuous delivery Pipeline run started events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param pipelineName
     * @param url
     * @return the cloudEvent object with continuous delivery
     * Pipeline run started event extensions
     */


    public static CloudEvent createPipelineRunStartedEvent(
            final String eventType,
            final String id, final URI source,
            final String pipelineName, final URI url,
            final String pipelineRunData){
        CloudEvent ceToSend =
                buildCloudEvent(eventType, pipelineRunData)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("pipelinename", pipelineName)
                        .withExtension("url", url)
                        .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery Task run started events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param taskName
     * @param pipelineRun
     * @param url
     * @return the cloudEvent object with continuous delivery
     * task run started event extensions
     */

    public static CloudEvent createTaskRunStartedEvent(
            final String eventType, final String id,
            final URI source, final String taskName,
            final String pipelineRun, final URI url,
            final String taskRunData)
    {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, taskRunData)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("taskname", taskName)
                        .withExtension("pipelinerun", pipelineRun)
                        .withExtension("url", url)
                        .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery Task run finished events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param taskName
     * @param pipelineRun
     * @param url
     * @param outcome
     * @param errors
     * @return the cloudEvent object with continuous delivery
     * task run finished event extensions
     */


    public static CloudEvent createTaskRunFinishedEvent(
            final String eventType, final String id,
            final URI source, final String taskName,
            final String pipelineRun, final URI url,
            final CDEventConstants.Outcome outcome, final String errors,
            final String taskRunData)
    {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, taskRunData)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("taskname", taskName)
                        .withExtension("pipelinerun", pipelineRun)
                        .withExtension("url", url)
                        .withExtension("outcome", outcome.getOutcome())
                        .withExtension("errors", errors)
                        .build();
        return ceToSend;
    }


    /**
     * Creates a continuous delivery repository created event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param name
     * @param owner
     * @param url
     * @param view
     * @param data
     * @return the cloudEvent object with continuous delivery
     * repository created event extensions
     */

    public static CloudEvent createRepositoryCreatedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI view, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source",source)
                        .withExtension("name", name)
                        .withExtension("owner",owner)
                        .withExtension("url", url)
                        .withExtension("view", view)
                        .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery repository modified event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param name
     * @param owner
     * @param url
     * @param view
     * @param data
     * @return the cloudEvent object with continuous delivery
     * repository modified event extensions
     */

    public static CloudEvent createRepositoryModifiedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI view, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source",source)
                        .withExtension("name", name)
                        .withExtension("owner",owner)
                        .withExtension("url", url)
                        .withExtension("view", view)
                        .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery repository deleted event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param name
     * @param owner
     * @param url
     * @param view
     * @param data
     * @return the cloudEvent object with continuous delivery
     * repository deleted event extensions
     */

    public static CloudEvent createRepositoryDeletedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI view, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source",source)
                        .withExtension("name", name)
                        .withExtension("owner",owner)
                        .withExtension("url", url)
                        .withExtension("view", view)
                        .build();
        return ceToSend;
    }

    /**
     * Creates a continuous delivery branch created event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * branch created event extensions
     */
    public static CloudEvent createBranchCreatedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source", source)
                        .withExtension("repository", repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery branch deleted event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * branch deleted event extensions
     */

    public static CloudEvent createBranchDeletedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source", source)
                        .withExtension("repository", repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change created event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change created event extensions
     */

    public static CloudEvent createChangeCreatedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .withExtension("repository",repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change reviewed event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change reviewed event extensions
     */

    public static CloudEvent createChangeReviewedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .withExtension("repository",repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change merged event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change merged event extensions
     */

    public static CloudEvent createChangeMergedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .withExtension("repository",repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change abandoned event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change abandoned event extensions
     */

    public static CloudEvent createChangeAbandonedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .withExtension("repository",repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change updated event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change updated event extensions
     */

    public static CloudEvent createChangeUpdatedEvent(
            final String eventType, final String id,
            final URI source, final String repository,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .withExtension("repository",repository)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery build queued event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build queued event extensions
     */

    public static CloudEvent createBuildQueuedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend = 
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery build started event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build started event extensions
     */

    public static CloudEvent createBuildStartedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery build finished event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build finished event extensions
     */

    public static CloudEvent createBuildFinishedEvent(
            final String eventType, final String id,
            final URI source, final URI artifactId,
            final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .withExtension("artifactid", artifactId)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery testcase queued event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * testcase queued event extensions
     */

    public static CloudEvent createTestCaseQueuedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery testcase started event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * testcase started event extensions
     */

    public static CloudEvent createTestCaseStartedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery testcase finished event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * testcase finished event extensions
     */

    public static CloudEvent createTestCaseFinishedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery test suite started event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * test suite started queued event extensions
     */

    public static CloudEvent createTestSuiteStartedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery test suite finished event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * test suite finished queued event extensions
     */

    public static CloudEvent createTestSuiteFinishedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery artifact packaged event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * artifact packaged queued event extensions
     */

    public static CloudEvent createArtifactPackagedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery artifact published event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * artifact published queued event extensions
     */

    public static CloudEvent createArtifactPublishedEvent(
            final String eventType, final String id,
            final URI source, final String data){
        CloudEvent cdToSend =
                buildCloudEvent(eventType,data)
                        .withExtension("id",id)
                        .withExtension("source",source)
                        .build();
        return cdToSend;
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
