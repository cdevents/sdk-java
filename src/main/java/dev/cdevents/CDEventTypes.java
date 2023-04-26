package dev.cdevents;

import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ArtifactPackagedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ArtifactPublishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.BranchCreatedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.BranchDeletedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.BuildFinishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.BuildQueuedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.BuildStartedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ChangeAbandonedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ChangeCreatedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ChangeMergedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ChangeReviewedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ChangeUpdatedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.EnvironmentCreatedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.EnvironmentDeletedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.EnvironmentModifiedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.PipelineRunFinishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.PipelineRunQueuedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.PipelineRunStartedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.RepositoryCreatedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.RepositoryDeletedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.RepositoryModifiedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ServiceDeployedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ServicePublishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ServiceRemovedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ServiceRolledBackEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.ServiceUpgradedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TaskRunFinishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TaskRunStartedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TestCaseFinishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TestCaseQueuedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TestCaseStartedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TestSuiteFinishedEvent;
import static dev.cdevents.constants.CDEventConstants.CDEventTypes.TestSuiteStartedEvent;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.Environment;
import dev.cdevents.models.PipelineRun;
import dev.cdevents.models.Repository;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.v03.CloudEventBuilder;

public final class CDEventTypes {

    /**
     * Object Mapper for mapping PipelineRun, Environment and Repository
     * objects to String.
     */
    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * Logger for logging errors.
     */
    private static Logger log = LoggerFactory.getLogger(CDEventTypes.class);

    private CDEventTypes() {
    }

    /**
     * Creates continuous delivery Pipeline run finished events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
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
            final String id, final URI source, final String pipelineName,
            final URI url, final CDEventConstants.Outcome outcome,
            final String errors, final String pipelineRunData) {
        CloudEvent ceToSend =
                buildCloudEvent(PipelineRunFinishedEvent, pipelineRunData)
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
     * @param id
     * @param source
     * @param pipelineName
     * @param url
     * @param pipelineRunData
     * @return the cloudEvent object with continuous delivery
     * Pipeline run queued event extensions
     */


    public static CloudEvent createPipelineRunQueuedEvent(
            final String id, final URI source,
            final String pipelineName, final URI url,
            final String pipelineRunData) {
        CloudEvent ceToSend =
                buildCloudEvent(PipelineRunQueuedEvent, pipelineRunData)
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
     * @param id
     * @param source
     * @param pipelineName
     * @param url
     * @param pipelineRunData
     * @return the cloudEvent object with continuous delivery
     * Pipeline run started event extensions
     */


    public static CloudEvent createPipelineRunStartedEvent(
            final String id, final URI source,
            final String pipelineName, final URI url,
            final String pipelineRunData) {
        CloudEvent ceToSend =
                buildCloudEvent(PipelineRunStartedEvent, pipelineRunData)
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
            final String id,
            final URI source, final String taskName,
            final PipelineRun pipelineRun, final URI url,
            final String taskRunData) {
        CloudEvent ceToSend =
                null;
        try {
            ceToSend = buildCloudEvent(TaskRunStartedEvent, taskRunData)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("taskname", taskName)
                    .withExtension("pipelinerun",
                            objectMapper.writeValueAsString(pipelineRun))
                    .withExtension("url", url)
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "TaskRun Started Event {}", e);
        }
        return ceToSend;
    }

    /**
     * Creates a continuous delivery Task run finished events
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
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
            final String id,
            final URI source, final String taskName,
            final PipelineRun pipelineRun, final URI url,
            final CDEventConstants.Outcome outcome, final String errors,
            final String taskRunData) {
        CloudEvent ceToSend =
                null;
        try {
            ceToSend = buildCloudEvent(TaskRunFinishedEvent, taskRunData)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("taskname", taskName)
                    .withExtension("pipelinerun",
                            objectMapper.writeValueAsString(pipelineRun))
                    .withExtension("url", url)
                    .withExtension("outcome", outcome.getOutcome())
                    .withExtension("errors", errors)
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "TaskRun Finished Event{}", e);
        }
        return ceToSend;
    }


    /**
     * Creates a continuous delivery repository created event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
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
            final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI viewUrl, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(RepositoryCreatedEvent, data)
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
            final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI viewUrl, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(RepositoryModifiedEvent, data)
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
            final String id,
            final URI source, final String name,
            final String owner, final URI url,
            final URI viewUrl, final String data) {
        CloudEvent ceToSend =
                buildCloudEvent(RepositoryDeletedEvent, data)
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
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * branch created event extensions
     */
    public static CloudEvent createBranchCreatedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(BranchCreatedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Branch Created Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery branch deleted event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     *
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * branch deleted event extensions
     */

    public static CloudEvent createBranchDeletedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(BranchDeletedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Branch Deleted Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change created event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change created event extensions
     */

    public static CloudEvent createChangeCreatedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ChangeCreatedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Change Created Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change reviewed event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change reviewed event extensions
     */

    public static CloudEvent createChangeReviewedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ChangeReviewedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Change Reviewed Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change merged event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change merged event extensions
     */

    public static CloudEvent createChangeMergedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ChangeMergedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Change Merged Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change abandoned event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change abandoned event extensions
     */

    public static CloudEvent createChangeAbandonedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ChangeAbandonedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Change Abandoned Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery change updated event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param source
     * @param repository
     * @param data
     * @return the cloudEvent object with continuous delivery
     * change updated event extensions
     */

    public static CloudEvent createChangeUpdatedEvent(
            final String id,
            final URI source, final Repository repository,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ChangeUpdatedEvent, data)
                    .withExtension("id", id)
                    .withExtension("source", source)
                    .withExtension("repository",
                            objectMapper.writeValueAsString(repository))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Change Updated Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery build queued event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build queued event extensions
     */

    public static CloudEvent createBuildQueuedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(BuildQueuedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build started event extensions
     */

    public static CloudEvent createBuildStartedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(BuildStartedEvent, data)
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
     * @param id
     * @param source
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * build finished event extensions
     */

    public static CloudEvent createBuildFinishedEvent(
            final String id,
            final URI source, final URI artifactId,
            final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(BuildFinishedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * testcase queued event extensions
     */

    public static CloudEvent createTestCaseQueuedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(TestCaseQueuedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * testcase started event extensions
     */

    public static CloudEvent createTestCaseStartedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(TestCaseStartedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * testcase finished event extensions
     */

    public static CloudEvent createTestCaseFinishedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(TestCaseFinishedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * test suite started queued event extensions
     */

    public static CloudEvent createTestSuiteStartedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(TestSuiteStartedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * test suite finished queued event extensions
     */

    public static CloudEvent createTestSuiteFinishedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(TestSuiteFinishedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * artifact packaged queued event extensions
     */

    public static CloudEvent createArtifactPackagedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(ArtifactPackagedEvent, data)
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
     * @param id
     * @param source
     * @param data
     * @return the cloudEvent object with continuous delivery
     * artifact published event extensions
     */

    public static CloudEvent createArtifactPublishedEvent(
            final String id,
            final URI source, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(ArtifactPublishedEvent, data)
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
     * @param id
     * @param source
     * @param name
     * @param url
     * @param data
     * @return the cloudEvent object with continuous delivery
     * environment created event
     */

    public static CloudEvent createEnvironmentCreatedEvent(
            final String id,
            final URI source, final String name,
            final String url, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(EnvironmentCreatedEvent, data)
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
     * @param id
     * @param source
     * @param name
     * @param url
     * @param data
     * @return the cloudEvent object with continuous delivery
     * environment created event
     */

    public static CloudEvent createEnvironmentModifiedEvent(
            final String id,
            final URI source, final String name,
            final String url, final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(EnvironmentModifiedEvent, data)
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
     * @param id
     * @param source
     * @param name
     * @param data
     * @return the cloudEvent object with continuous delivery
     * environment deleted event
     */

    public static CloudEvent createEnvironmentDeletedEvent(
            final String id,
            final URI source, final String name,
            final String data) {
        CloudEvent cdToSend =
                buildCloudEvent(EnvironmentDeletedEvent, data)
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
     * @param id
     * @param environment
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service deployed event
     */

    public static CloudEvent createServiceDeployedEvent(
            final String id,
            final Environment environment, final URL artifactId,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            return buildCloudEvent(ServiceDeployedEvent, data)
                    .withExtension("id", id)
                    .withExtension("environment",
                            objectMapper.writeValueAsString(environment))
                    .withExtension("artifactid", artifactId.toString())
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Service Deployed Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service upgraded event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param environment
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service upgraded event
     */

    public static CloudEvent createServiceUpgradedEvent(
            final String id,
            final Environment environment, final URL artifactId,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ServiceUpgradedEvent, data)
                    .withExtension("id", id)
                    .withExtension("environment",
                            objectMapper.writeValueAsString(environment))
                    .withExtension("artifactid", artifactId.toString())
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Service Upgraded Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service rolled back event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param environment
     * @param artifactId
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service rolled back event
     */

    public static CloudEvent createServiceRolledBackEvent(
            final String id,
            final Environment environment, final URL artifactId,
            final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ServiceRolledBackEvent, data)
                    .withExtension("id", id)
                    .withExtension("environment",
                            objectMapper.writeValueAsString(environment))
                    .withExtension("artifactid", artifactId.toString())
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Service Rolled Back Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service removed event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param environment
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service removed event
     */

    public static CloudEvent createServiceRemovedEvent(
            final String id,
            final Environment environment, final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ServiceRemovedEvent, data)
                    .withExtension("id", id)
                    .withExtension("environment",
                            objectMapper.writeValueAsString(environment))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Service Removed Event{}", e);
        }
        return cdToSend;
    }

    /**
     * Creates a continuous delivery service published event
     * using {@link CloudEventBuilder}
     * and returns {@link CloudEvent} object.
     *
     * @param id
     * @param environment
     * @param data
     * @return the cloudEvent object with continuous delivery
     * service published event
     */

    public static CloudEvent createServicePublishedEvent(
            final String id,
            final Environment environment, final String data) {
        CloudEvent cdToSend =
                null;
        try {
            cdToSend = buildCloudEvent(ServicePublishedEvent, data)
                    .withExtension("id", id)
                    .withExtension("environment",
                            objectMapper.writeValueAsString(environment))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("Exception occurred when creating "
                    + "Service Published Event{}", e);
        }
        return cdToSend;
    }


    private static CloudEventBuilder buildCloudEvent(
            final dev.cdevents.constants.CDEventConstants.CDEventTypes eventType, final String eventData) {
        return new CloudEventBuilder()
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create("cdevents-sdk-java"))
                .withType(eventType.getEventType())
                .withData(eventData.getBytes(StandardCharsets.UTF_8))
                .withTime(OffsetDateTime.now());
    }
}
