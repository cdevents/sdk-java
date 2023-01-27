package dev.cdevents;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.Environment;
import dev.cdevents.models.PipelineRun;
import dev.cdevents.models.Repository;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.v03.CloudEventBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CDEventTypes {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(CDEventTypes.class);

    private CDEventTypes() {
    }

    /**
     * Creates continuous delivery Pipeline run finished events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param pipelineName
     * @param url
     * @param outcome
     * @param errors
     * @param pipelineRunData
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
     * @param source
     * @param pipelineName
     * @param url
     * @param pipelineRunData
     * @return the cloudEvent object with continuous delivery
     * Pipeline run queued event extensions
     */


    public static CloudEvent createPipelineRunQueuedEvent(
            final String eventType,
            final String id, final URI source,
            final String pipelineName, final URI url,
            final String pipelineRunData) {
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
     * @param source
     * @param pipelineName
     * @param url
     * @param pipelineRunData
     * @return the cloudEvent object with continuous delivery
     * Pipeline run started event extensions
     */


    public static CloudEvent createPipelineRunStartedEvent(
            final String eventType,
            final String id, final URI source,
            final String pipelineName, final URI url,
            final String pipelineRunData) {
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
     * @param taskRunData
     * @return the cloudEvent object with continuous delivery
     * task run started event extensions
     */

    public static CloudEvent createTaskRunStartedEvent(
            final String eventType, final String id,
            final URI source, final String taskName,
            final PipelineRun pipelineRun, final URI url,
            final String taskRunData) {
        CloudEvent ceToSend =
                null;
        try {
            ceToSend = buildCloudEvent(eventType, taskRunData)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("taskname", taskName)
                    .withExtension("pipelinerun", objectMapper.writeValueAsString(pipelineRun))
                    .withExtension("url", url)
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event {}",e);
        }
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
     * @param taskRunData
     * @return the cloudEvent object with continuous delivery
     * task run finished event extensions
     */


    public static CloudEvent createTaskRunFinishedEvent(
            final String eventType, final String id,
            final URI source, final String taskName,
            final PipelineRun pipelineRun, final URI url,
            final CDEventConstants.Outcome outcome, final String errors,
            final String taskRunData) {
        CloudEvent ceToSend =
                null;
        try {
            ceToSend = buildCloudEvent(eventType, taskRunData)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("taskname", taskName)
                    .withExtension("pipelinerun", objectMapper.writeValueAsString(pipelineRun))
                    .withExtension("url", url)
                    .withExtension("outcome", outcome.getOutcome())
                    .withExtension("errors", errors)
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
     * @param viewUrl
     * @param data
     * @return the cloudEvent object with continuous delivery
     * repository created event extensions
     */

    public static CloudEvent createRepositoryCreatedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI viewUrl, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("name", name)
                        .withExtension("owner", owner)
                        .withExtension("url", url)
                        .withExtension("viewurl", viewUrl)
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
     * @param viewUrl
     * @param data
     * @return the cloudEvent object with continuous delivery
     * repository modified event extensions
     */

    public static CloudEvent createRepositoryModifiedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI viewUrl, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("name", name)
                        .withExtension("owner", owner)
                        .withExtension("url", url)
                        .withExtension("viewurl", viewUrl)
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
     * @param viewUrl
     * @param data
     * @return the cloudEvent object with continuous delivery
     * repository deleted event extensions
     */

    public static CloudEvent createRepositoryDeletedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI viewUrl, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("name", name)
                        .withExtension("owner", owner)
                        .withExtension("url", url)
                        .withExtension("viewurl", viewUrl)
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository) )
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository", objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build finished event extensions
     */

    public static CloudEvent createBuildFinishedEvent(
            final String eventType, final String id,
            final URI source, final URI artifactId,
            final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("artifactid",  artifactId)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
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
     * artifact published event extensions
     */

    public static CloudEvent createArtifactPublishedEvent(
            final String eventType, final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery environment created event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param name
     * @param url
     * @param data
     * @return the cloudEvent object with continuous delivery
     * environment created event
     */

    public static CloudEvent createEnvironmentCreatedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String url, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("name", name)
                        .withExtension("url", url)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery environment modified event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param name
     * @param url
     * @param data
     * @return the cloudEvent object with continuous delivery
     * environment created event
     */

    public static CloudEvent createEnvironmentModifiedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String url, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("name", name)
                        .withExtension("url", url)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery environment deleted event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param source
     * @param name
     * @param data
     * @return the cloudEvent object with continuous delivery
     * environment deleted event
     */

    public static CloudEvent createEnvironmentDeletedEvent(
            final String eventType, final String id,
            final URI source, final String name,
            final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(eventType, data)
                        .withExtension("id", id)
                        .withExtension("source", source)
                        .withExtension("name", name)
                        .build();
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service deployed event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param environment
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service deployed event
     */

    public static CloudEvent createServiceDeployedEvent(
            final String eventType, final String id,
            final Environment environment, final URL artifactId,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("environment",  objectMapper.writeValueAsString(environment))
                    .withExtension("artifactid", artifactId.toString())
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service upgraded event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param environment
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service upgraded event
     */

    public static CloudEvent createServiceUpgradedEvent(
            final String eventType, final String id,
            final Environment environment, final URL artifactId,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("environment", objectMapper.writeValueAsString(environment))
                    .withExtension("artifactid", artifactId.toString())
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service rolled back event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param environment
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service rolled back event
     */

    public static CloudEvent createServiceRolledBackEvent(
            final String eventType, final String id,
            final Environment environment, final URL artifactId,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("environment", objectMapper.writeValueAsString(environment))
                    .withExtension("artifactid", artifactId.toString())
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service removed event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param environment
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service removed event
     */

    public static CloudEvent createServiceRemovedEvent(
            final String eventType, final String id,
            final Environment environment, final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("environment", objectMapper.writeValueAsString(environment))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service published event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param eventType
     * @param id
     * @param environment
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service published event
     */

    public static CloudEvent createServicePublishedEvent(
            final String eventType, final String id,
            final Environment environment, final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(eventType, data)
                    .withExtension("id", id)
                    .withExtension("environment", objectMapper.writeValueAsString(environment))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating TaskRun Started Event{}",e);
        }
        return cdToSend;
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
