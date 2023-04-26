/**
 * Copyright 2022-Present https://cdevents.dev/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package dev.cdevents;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.Environment;
import dev.cdevents.models.PipelineRun;
import dev.cdevents.models.Repository;
import org.junit.jupiter.api.Test;

import io.cloudevents.CloudEvent;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CDEventTypesTest {


    /**
     * Object Mapper for writing Environment, Repository and PipelineRun objects to json string.
     */
    private static ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void createPipelineRunFinishedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createPipelineRunFinishedEvent(
                "id", url, "name", url,
                CDEventConstants.Outcome.SUCCESS, "errors", "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source",
                        "pipelinename", "url", "outcome", "errors");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("pipelinename")).isEqualTo("name");
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
        assertThat(cdEvent.getExtension("outcome")).isEqualTo(
                CDEventConstants.Outcome.SUCCESS.getOutcome());
        assertThat(cdEvent.getExtension("errors")).isEqualTo("errors");
    }

    @Test
    void createPipelineRunStartedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createPipelineRunStartedEvent(
                "id", url, "name",  url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source",
                        "pipelinename", "url");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("pipelinename")).isEqualTo("name");
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
    }

    @Test
    void createPipelineRunQueuedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createPipelineRunQueuedEvent(
                "id", url, "name",  url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source",
                        "pipelinename", "url");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("pipelinename")).isEqualTo("name");
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
    }

    @Test
    void createTaskRunStartedTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        PipelineRun pipelineRun = new PipelineRun();

        CloudEvent cdEvent = CDEventTypes.createTaskRunStartedEvent(
                "id", url, "taskname", pipelineRun, url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "taskname",
                        "pipelinerun", "url");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("taskname")).isEqualTo("taskname");
        assertThat(cdEvent.getExtension("pipelinerun")).
                isEqualTo(objectMapper.writeValueAsString(pipelineRun));
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
    }

    @Test
    void createTaskRunFinishedTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        PipelineRun pipelineRun = new PipelineRun();
        CloudEvent cdEvent = CDEventTypes.createTaskRunFinishedEvent(
                "id", url,
                "taskname", pipelineRun, url, CDEventConstants.Outcome.
                        SUCCESS, "errors", "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "taskname",
                        "pipelinerun", "url", "outcome", "errors");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("taskname")).isEqualTo("taskname");
        assertThat(cdEvent.getExtension("pipelinerun")).
                isEqualTo(objectMapper.writeValueAsString(pipelineRun));
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
        assertThat(cdEvent.getExtension("outcome")).
                isEqualTo(CDEventConstants.Outcome.SUCCESS.getOutcome());
        assertThat(cdEvent.getExtension("errors")).isEqualTo("errors");
    }

    @Test
    void createRepositoryCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryCreatedEvent(
                "id", url, "name", "owner", url, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name",
                        "owner", "url", "viewurl");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("name")).isEqualTo("name");
        assertThat(cdEvent.getExtension("owner")).isEqualTo("owner");
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
        assertThat(cdEvent.getExtension("viewurl")).isEqualTo(url);
    }

    @Test
    void createRepositoryModifiedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryModifiedEvent(
                "id", url, "name", "owner", url, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name",
                        "owner", "url", "viewurl");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("name")).isEqualTo("name");
        assertThat(cdEvent.getExtension("owner")).isEqualTo("owner");
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
        assertThat(cdEvent.getExtension("viewurl")).isEqualTo(url);
    }

    @Test
    void createRepositoryDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryDeletedEvent(
                "id", url, "name", "owner", url, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name",
                        "owner", "url", "viewurl");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("name")).isEqualTo("name");
        assertThat(cdEvent.getExtension("owner")).isEqualTo("owner");
        assertThat(cdEvent.getExtension("url")).isEqualTo(url);
        assertThat(cdEvent.getExtension("viewurl")).isEqualTo(url);
    }

    @Test
    void createBranchCreatedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createBranchCreatedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createBranchDeletedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createBranchDeletedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createChangeCreatedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeCreatedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createChangeReviewedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeReviewedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createChangeMergedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeMergedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createChangeAbandonedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeAbandonedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createChangeUpdatedEventTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeUpdatedEvent(
                "id", url, repository, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "repository");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("repository")).
                isEqualTo(objectMapper.writeValueAsString(repository));
    }

    @Test
    void createBuildQueuedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBuildQueuedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createBuildStartedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBuildStartedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createBuildFinishedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBuildFinishedEvent(
                "id", url, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "artifactid");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("artifactid")).isEqualTo(url);
    }

    @Test
    void createTestCaseQueuedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestCaseQueuedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createTestCaseStartedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestCaseStartedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createTestCaseFinishedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestCaseFinishedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createTestSuiteStartedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestSuiteStartedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createTestSuiteFinishedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestSuiteFinishedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createArtifactPackagedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createArtifactPackagedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createArtifactPublishedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createArtifactPublishedEvent(
                "id", url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
    }

    @Test
    void createEnvironmentCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createEnvironmentCreatedEvent(
                "id", url, "name", "url", "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name", "url");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("name")).isEqualTo("name");
        assertThat(cdEvent.getExtension("url")).isEqualTo("url");
    }

    @Test
    void createEnvironmentModifiedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createEnvironmentModifiedEvent(
                "id", url, "name", "url", "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name", "url");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("name")).isEqualTo("name");
        assertThat(cdEvent.getExtension("url")).isEqualTo("url");
    }

    @Test
    void createEnvironmentDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createEnvironmentDeletedEvent(
                "id", url, "name", "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("source")).isEqualTo(url);
        assertThat(cdEvent.getExtension("name")).isEqualTo("name");
    }

    @Test
    void createServiceDeployedTest()
            throws URISyntaxException, JsonProcessingException,
            MalformedURLException {
        URI url = new URI("cdevents.dev");
        URL purl = new URL("https://www.cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceDeployedEvent(
                "id", environment, purl, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "environment", "artifactid");


        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("environment")).
                isEqualTo(objectMapper.writeValueAsString(environment));
        assertThat(cdEvent.getExtension("artifactid")).
                isEqualTo(purl.toString());
    }

    @Test
    void createServiceUpgradedTest()
            throws URISyntaxException, JsonProcessingException,
            MalformedURLException {
        URI url = new URI("cdevents.dev");
        URL purl = new URL("https://www.cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceUpgradedEvent(
                "id", environment, purl, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "environment", "artifactid");

        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("environment")).
                isEqualTo(objectMapper.writeValueAsString(environment));
        assertThat(cdEvent.getExtension("artifactid")).
                isEqualTo(purl.toString());
    }

    @Test
    void createServiceRolledBackTest()
            throws URISyntaxException, JsonProcessingException,
            MalformedURLException {
        URI url = new URI("cdevents.dev");
        URL purl = new URL("https://www.cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceRolledBackEvent(
                "id", environment, purl, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "environment", "artifactid");


        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("environment")).
                isEqualTo(objectMapper.writeValueAsString(environment));
        assertThat(cdEvent.getExtension("artifactid")).
                isEqualTo(purl.toString());
    }

    @Test
    void createServiceRemovedTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        
        CloudEvent cdEvent = CDEventTypes.createServiceRemovedEvent(
                "id", environment, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "environment");
        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("environment")).
                isEqualTo(objectMapper.writeValueAsString(environment));
    }

    @Test
    void createServicePublishedTest()
            throws URISyntaxException, JsonProcessingException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        
        CloudEvent cdEvent = CDEventTypes.createServicePublishedEvent(
                "id", environment, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "environment");
        assertThat(cdEvent.getExtension("id")).isEqualTo("id");
        assertThat(cdEvent.getExtension("environment")).
                isEqualTo(objectMapper.writeValueAsString(environment));
    }

}