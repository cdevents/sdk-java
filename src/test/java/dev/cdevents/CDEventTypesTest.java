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

import dev.cdevents.constants.CDEventConstants;
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
        CloudEvent cdEvent = CDEventTypes.createTaskRunStartedEvent(
                CDEventConstants.CDEventTypes.TaskRunStartedEvent.getEventType(),
                "id", url, "taskname","pipelinerun", url, "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source","taskname","pipelinerun","url");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("taskname").equals("taskname"));
        assertThat(cdEvent.getExtension("pipelinerun").equals("pipelinerun"));
        assertThat(cdEvent.getExtension("url").equals(url));
    }

    @Test
    void createTaskRunFinishedTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createTaskRunFinishedEvent(
                CDEventConstants.CDEventTypes.TaskRunFinishedEvent.getEventType(),
                "id", url, "taskname","pipelinerun", url, CDEventConstants.Outcome.OutcomeSuccess, "errors", "data");

        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id", "source","taskname","pipelinerun","url","outcome","errors");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("taskname").equals("taskname"));
        assertThat(cdEvent.getExtension("pipelinerun").equals("pipelinerun"));
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
                .containsExactlyInAnyOrder("id","source","name","owner","url","view");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("owner").equals("owner"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("view").equals(url));
    }

    @Test
    void createRepositoryModifiedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryModifiedEvent(
                CDEventConstants.CDEventTypes.RepositoryModifiedEvent.getEventType(),
                "id", url,"name","owner",url, url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","name","owner","url","view");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("owner").equals("owner"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("view").equals(url));
    }

    @Test
    void createRepositoryDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createRepositoryDeletedEvent(
                CDEventConstants.CDEventTypes.RepositoryDeletedEvent.getEventType(),
                "id", url,"name","owner",url, url,"data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","name","owner","url","view");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("name").equals("name"));
        assertThat(cdEvent.getExtension("owner").equals("owner"));
        assertThat(cdEvent.getExtension("url").equals(url));
        assertThat(cdEvent.getExtension("view").equals(url));
    }

    @Test
    void createBranchCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBranchCreatedEvent(
                CDEventConstants.CDEventTypes.BranchCreatedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createBranchDeletedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createBranchDeletedEvent(
                CDEventConstants.CDEventTypes.BranchDeletedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createChangeCreatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createChangeCreatedEvent(
                CDEventConstants.CDEventTypes.ChangeCreatedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createChangeReviewedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createChangeReviewedEvent(
                CDEventConstants.CDEventTypes.ChangeReviewedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createChangeMergedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createChangeMergedEvent(
                CDEventConstants.CDEventTypes.ChangeMergedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createChangeAbandonedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createChangeAbandonedEvent(
                CDEventConstants.CDEventTypes.ChangeAbandonedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createChangeUpdatedEventTest() throws URISyntaxException {
        URI url = new URI("cdevents.dev");
        CloudEvent cdEvent = CDEventTypes.createChangeUpdatedEvent(
                CDEventConstants.CDEventTypes.ChangeUpdatedEvent.getEventType(),
                "id",url,"repo","data");
        assertThat(cdEvent.getExtensionNames())
                .containsExactlyInAnyOrder("id","source","repository");

        assertThat(cdEvent.getExtension("id").equals("id"));
        assertThat(cdEvent.getExtension("source").equals(url));
        assertThat(cdEvent.getExtension("repository").equals("repo"));
    }

    @Test
    void createBuildQueuedEvent() throws URISyntaxException{
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
    void createBuildStartedEvent() throws URISyntaxException{
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
    void createBuildFinishedEvent() throws URISyntaxException{
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
    void createTestCaseQueuedEvent() throws URISyntaxException{
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
    void createTestCaseStartedEvent() throws URISyntaxException{
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
    void createTestCaseFinishedEvent() throws URISyntaxException{
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
    void createTestSuiteStartedEvent() throws URISyntaxException{
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
    void createTestSuiteFinishedEvent() throws URISyntaxException{
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
    void createArtifactPackagedEvent() throws URISyntaxException{
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
    void createArtifactPublishedEvent() throws URISyntaxException{
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
    void createTestEventTest() {
        CloudEvent cdEvent = CDEventTypes.createTestEvent(
                CDEventConstants.CDEventTypes.ArtifactCreatedEvent.getEventType(),
                "id", "name", "version", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("testid", "testname", "testversion");

        assertThat(cdEvent.getExtension("testid").equals("id"));
        assertThat(cdEvent.getExtension("testname").equals("name"));
        assertThat(cdEvent.getExtension("testversion").equals("version"));
    }


    @Test
    void createEnvironmentEventTest() {
        CloudEvent cdEvent = CDEventTypes
                .createEnvironmentEvent(
                CDEventConstants.CDEventTypes.ArtifactCreatedEvent.getEventType(),
                "id", "name", "repoURL", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("envid", "envname", "envrepourl");

        assertThat(cdEvent.getExtension("envid").equals("id"));
        assertThat(cdEvent.getExtension("envname").equals("name"));
        assertThat(cdEvent.getExtension("envrepourl").equals("repoURL"));
    }

    @Test
    void createServiceEventTest() {
        CloudEvent cdEvent = CDEventTypes.createServiceEvent(
                CDEventConstants.CDEventTypes.ArtifactCreatedEvent.getEventType(),
                "id", "name", "version", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("serviceid",
                "servicename", "serviceversion");

        assertThat(cdEvent.getExtension("serviceid").equals("id"));
        assertThat(cdEvent.getExtension("servicename").equals("name"));
        assertThat(cdEvent.getExtension("serviceversion").equals("version"));
    }
}
