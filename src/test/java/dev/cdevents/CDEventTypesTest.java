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

import org.junit.jupiter.api.Test;

import io.cloudevents.CloudEvent;

public class CDEventTypesTest {

    @Test
    void createPipelineRunEventTest() {
        CloudEvent cdEvent = CDEventTypes.createPipelineRunEvent(
                CDEventEnums.PipelineRunStartedEventV1.getEventType(),
                "id", "name", "status", "url", "noErrors", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("pipelinerunid", "pipelinerunname",
                "pipelinerunstatus", "pipelinerunurl", "pipelinerunerrors");

        assertThat(cdEvent.getExtension("pipelinerunid").equals("id"));
        assertThat(cdEvent.getExtension("pipelinerunname").equals("name"));
        assertThat(cdEvent.getExtension("pipelinerunstatus").equals("status"));
        assertThat(cdEvent.getExtension("pipelinerunurl").equals("url"));
        assertThat(cdEvent.getExtension("pipelinerunerrors")
                .equals("noErrors"));
    }

    @Test
    void createTaskRunEventTest() {
        CloudEvent cdEvent = CDEventTypes.createTaskRunEvent(
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
                "id", "name", "pipelineId", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("taskrunid",
                "taskrunname", "taskrunpipelineid");

        assertThat(cdEvent.getExtension("taskrunid").equals("id"));
        assertThat(cdEvent.getExtension("taskrunname").equals("name"));
        assertThat(cdEvent.getExtension("taskrunpipelineid")
                .equals("pipelineId"));
    }

    @Test
    void createRepositoryEventTest() {
        CloudEvent cdEvent = CDEventTypes.createRepositoryEvent(
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
                "id", "name", "url", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("repositoryid",
                "repositoryname", "repositoryurl");

        assertThat(cdEvent.getExtension("repositoryid").equals("id"));
        assertThat(cdEvent.getExtension("repositoryname").equals("name"));
        assertThat(cdEvent.getExtension("repositoryurl").equals("url"));
    }

    @Test
    void createBuildEventTest() {
        CloudEvent cdEvent = CDEventTypes.createBuildEvent(
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
                "id", "name", "artifactId", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("buildid", "buildname", "buildartifactid");

        assertThat(cdEvent.getExtension("buildid").equals("id"));
        assertThat(cdEvent.getExtension("buildname").equals("name"));
        assertThat(cdEvent.getExtension("buildartifactid")
                .equals("artifactId"));
    }

    @Test
    void createTestEventTest() {
        CloudEvent cdEvent = CDEventTypes.createTestEvent(
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
                "id", "name", "version", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("testid", "testname", "testversion");

        assertThat(cdEvent.getExtension("testid").equals("id"));
        assertThat(cdEvent.getExtension("testname").equals("name"));
        assertThat(cdEvent.getExtension("testversion").equals("version"));
    }

    @Test
    void createArtifactEventTest() {
        CloudEvent cdEvent = CDEventTypes.createArtifactEvent(
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
                "id", "name", "version", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("artifactid",
                "artifactname", "artifactversion");

        assertThat(cdEvent.getExtension("artifactid").equals("id"));
        assertThat(cdEvent.getExtension("artifactname").equals("name"));
        assertThat(cdEvent.getExtension("artifactversion").equals("version"));
    }

    @Test
    void createEnvironmentEventTest() {
        CloudEvent cdEvent = CDEventTypes
                .createEnvironmentEvent(
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
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
                CDEventEnums.ArtifactCreatedEventV1.getEventType(),
                "id", "name", "version", "data");

        assertThat(cdEvent.getExtensionNames())
        .containsExactlyInAnyOrder("serviceid",
                "servicename", "serviceversion");

        assertThat(cdEvent.getExtension("serviceid").equals("id"));
        assertThat(cdEvent.getExtension("servicename").equals("name"));
        assertThat(cdEvent.getExtension("serviceversion").equals("version"));
    }
}
