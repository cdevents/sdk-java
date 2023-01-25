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

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.Environment;
import dev.cdevents.models.PipelineRun;
import dev.cdevents.models.Repository;
import io.cloudevents.core.v03.CloudEventBuilder;
import org.junit.jupiter.api.Test;

import io.cloudevents.CloudEvent;

import java.net.URI;
import java.net.URISyntaxException;

public class CDEventTypesTest {

    @Test
    void createPipelineRunFinishedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createPipelineRunFinishedEvent(
                CDEventConstants.CDEventTypes.PipelineRunFinishedEvent.getEventType(),
                "id", url, "name", url, CDEventConstants.Outcome.OutcomeSuccess, "errors", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("id","source","pipelinename","url","outcome","errors");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("pipelinename").equals("name"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("outcome").equals(CDEventConstants.Outcome.OutcomeSuccess));
        assertThat(cdEvent.getExtension("errors").equals("errors"));
    }

    @Test
    void createPipelineRunStartedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createPipelineRunStartedEvent(
                CDEventConstants.CDEventTypes.PipelineRunStartedEvent.getEventType(),
                "id", url, "name",  url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","pipelinename","url");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("pipelinename").equals("name"));
        assertThat(cdEvent.getExtension("url").equals(url));
    }

    @Test
    void createPipelineRunQueuedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createPipelineRunQueuedEvent(
                CDEventConstants.CDEventTypes.PipelineRunQueuedEvent.getEventType(),
                "id", url, "name",  url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","pipelinename","url");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("pipelinename").equals("name"));
        assertThat(cdEvent.getExtension("url").equals(url));
    }

    @Test
    void createTaskRunStartedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        PipelineRun pipelineRun = new PipelineRun();
        CloudEvent cdEvent = CDEventTypes.createTaskRunStartedEvent(
                CDEventConstants.CDEventTypes.TaskRunStartedEvent.getEventType(),
                "id", url, "taskname",pipelineRun, url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source","taskname","pipelinerun","url");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("taskname").equals("taskname"));
        assertThat(cdEvent.getExtension("pipelinerun").equals(pipelineRun.toString()));
        assertThat(cdEvent.getExtension("url").equals(url));
    }

    @Test
    void createTaskRunFinishedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        PipelineRun pipelineRun = new PipelineRun();
        CloudEvent cdEvent = CDEventTypes.createTaskRunFinishedEvent(
                CDEventConstants.CDEventTypes.TaskRunFinishedEvent.getEventType(),
                "id", url, "taskname",pipelineRun, url, CDEventConstants.Outcome.OutcomeSuccess, "errors", "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source","taskname","pipelinerun","url","outcome","errors");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("taskname").equals("taskname"));
        assertThat(cdEvent.getExtension("pipelinerun").equals(pipelineRun.toString()));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("outcome").equals(CDEventConstants.Outcome.OutcomeSuccess));
        assertThat(cdEvent.getExtension("errors").equals("errors"));
    }

    @Test
    void createRepositoryCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryCreatedEvent(
                CDEventConstants.CDEventTypes.RepositoryCreatedEvent.getEventType(),
                "id", url,"name","owner",url, url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","name","owner","url","viewurl");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("owner").equals("owner"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("viewurl").equals(url));
    }

    @Test
    void createRepositoryModifiedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryModifiedEvent(
                CDEventConstants.CDEventTypes.RepositoryModifiedEvent.getEventType(),
                "id", url,"name","owner",url, url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","name","owner","url","viewurl");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("owner").equals("owner"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("viewurl").equals(url));
    }

    @Test
    void createRepositoryDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryDeletedEvent(
                CDEventConstants.CDEventTypes.RepositoryDeletedEvent.getEventType(),
                "id", url,"name","owner",url, url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","name","owner","url","viewurl");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("owner").equals("owner"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("viewurl").equals(url));
    }

    @Test
    void createBranchCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createBranchCreatedEvent(
                CDEventConstants.CDEventTypes.BranchCreatedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createBranchDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createBranchDeletedEvent(
                CDEventConstants.CDEventTypes.BranchDeletedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createChangeCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeCreatedEvent(
                CDEventConstants.CDEventTypes.ChangeCreatedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createChangeReviewedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeReviewedEvent(
                CDEventConstants.CDEventTypes.ChangeReviewedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createChangeMergedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeMergedEvent(
                CDEventConstants.CDEventTypes.ChangeMergedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createChangeAbandonedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeAbandonedEvent(
                CDEventConstants.CDEventTypes.ChangeAbandonedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createChangeUpdatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Repository repository = new Repository();
        CloudEvent cdEvent = CDEventTypes.createChangeUpdatedEvent(
                CDEventConstants.CDEventTypes.ChangeUpdatedEvent.getEventType(),
                "id",url,repository,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals(repository.toString()));
    }

    @Test
    void createBuildQueuedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBuildQueuedEvent(
                CDEventConstants.CDEventTypes.BuildQueuedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");
        
        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createBuildStartedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBuildStartedEvent(
                CDEventConstants.CDEventTypes.BuildStartedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createBuildFinishedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBuildFinishedEvent(
                CDEventConstants.CDEventTypes.BuildFinishedEvent.getEventType(),
                "id",url,url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","artifactid");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("artifactid").equals(url));
    }

    @Test
    void createTestCaseQueuedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestCaseQueuedEvent(
                CDEventConstants.CDEventTypes.TestCaseQueuedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createTestCaseStartedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestCaseStartedEvent(
                CDEventConstants.CDEventTypes.TestCaseStartedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createTestCaseFinishedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestCaseFinishedEvent(
                CDEventConstants.CDEventTypes.TestCaseFinishedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createTestSuiteStartedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestSuiteStartedEvent(
                CDEventConstants.CDEventTypes.TestSuiteStartedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createTestSuiteFinishedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTestSuiteFinishedEvent(
                CDEventConstants.CDEventTypes.TestSuiteFinishedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createArtifactPackagedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createArtifactPackagedEvent(
                CDEventConstants.CDEventTypes.ArtifactPackagedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }
    
    @Test
    void createArtifactPublishedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createArtifactPublishedEvent(
                CDEventConstants.CDEventTypes.ArtifactPublishedEvent.getEventType(),
                "id",url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
    }

    @Test
    void createEnvironmentCreatedEventTest() throws URISyntaxException{
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createEnvironmentCreatedEvent(
                CDEventConstants.CDEventTypes.EnvironmentCreatedEvent.getEventType(),
                "id", url, "name", "url", "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","name","url");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("url").equals("url"));
    }

    @Test
    void createEnvironmentModifiedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createEnvironmentModifiedEvent(
                CDEventConstants.CDEventTypes.EnvironmentModifiedEvent.getEventType(),
                "id", url, "name", "url", "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name", "url");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("url").equals("url"));
    }

    @Test
    void createEnvironmentDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createEnvironmentDeletedEvent(
                CDEventConstants.CDEventTypes.EnvironmentDeletedEvent.getEventType(),
                "id", url, "name", "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source", "name");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
    }
    
    @Test
    void createServiceDeployedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceDeployedEvent(
                CDEventConstants.CDEventTypes.ServiceDeployedEvent.getEventType(),
                "id", environment, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","environment","artifactid");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("environment").equals(environment.toString()));
        assertThat(cdEvent.getExtension("artifactid").equals("id"));
    }

    @Test
    void createServiceUpgradedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceUpgradedEvent(
                CDEventConstants.CDEventTypes.ServiceUpgradedEvent.getEventType(),
                "id", environment, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","environment","artifactid");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("environment").equals(environment.toString()));
        assertThat(cdEvent.getExtension("artifactid").equals("id"));
    }

    @Test
    void createServiceRolledBackTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceRolledBackEvent(
                CDEventConstants.CDEventTypes.ServiceRolledBackEvent.getEventType(),
                "id", environment, url, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","environment","artifactid");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("environment").equals(environment.toString()));
        assertThat(cdEvent.getExtension("artifactid").equals("id"));
    }

    @Test
    void createServiceRemovedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServiceRemovedEvent(
                CDEventConstants.CDEventTypes.ServiceRemovedEvent.getEventType(),
                "id", environment, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","environment");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("environment").equals(environment.toString()));
    }

    @Test
    void createServicePublishedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        Environment environment = new Environment("id", url, "name", "url");
        CloudEvent cdEvent = CDEventTypes.createServicePublishedEvent(
                CDEventConstants.CDEventTypes.ServicePublishedEvent.getEventType(),
                "id", environment, "data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","environment");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("environment").equals(environment.toString()));
    }

}
