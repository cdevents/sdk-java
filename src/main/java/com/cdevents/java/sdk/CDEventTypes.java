package com.cdevents.java.sdk;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.v03.CloudEventBuilder;

public class CDEventTypes {

	public static CloudEvent createPipelineRunEvent(String pipelineRunEventType, String pipelineRunId, String pipelineRunName,
			String pipelineRunStatus, String pipelineRunURL, String pipelineRunErrors, String pipelineRunData) {
		CloudEvent ceToSend = buildCloudEvent(pipelineRunEventType, pipelineRunData)
				.withExtension("pipelinerunid", pipelineRunId)
				.withExtension("pipelinerunname", pipelineRunName)
				.withExtension("pipelinerunstatus", pipelineRunStatus)
				.withExtension("pipelinerunurl", pipelineRunURL)
				.withExtension("pipelinerunerrors", pipelineRunErrors)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createTaskRunEvent(String taskRunEventType, String taskRunId, String taskRunName,
			String taskRunPipelineId, String taskRunData) {
		CloudEvent ceToSend = buildCloudEvent(taskRunEventType, taskRunData)
				.withExtension("taskrunid", taskRunId)
				.withExtension("taskrunname", taskRunName)
				.withExtension("taskrunpipelineid", taskRunPipelineId)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createRepositoryEvent(String repositoryEventType, String repositoryId, String repositoryName,
			String repositoryURL, String repositoryData) {
		CloudEvent ceToSend = buildCloudEvent(repositoryEventType, repositoryData)
				.withExtension("repositoryid", repositoryId)
				.withExtension("repositoryname", repositoryName)
				.withExtension("repositoryurl", repositoryURL)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createBuildEvent(String buildEventType, String buildId, String buildName,
			String buildArtifactId, String buildData) {
		CloudEvent ceToSend = buildCloudEvent(buildEventType, buildData)
				.withExtension("buildid", buildId)
				.withExtension("buildname", buildName)
				.withExtension("buildartifactid", buildArtifactId)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createTestEvent(String testEventType, String testId, String testName,
			String testVersion, String testData) {
		CloudEvent ceToSend = buildCloudEvent(testEventType, testData)
				.withExtension("testid", testId)
				.withExtension("testname", testName)
				.withExtension("testversion", testVersion)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createArtifactEvent(String artifactEventType, String artifactId, String artifactName,
			String artifactVersion, String artifactData) {
		CloudEvent ceToSend = buildCloudEvent(artifactEventType, artifactData)
				.withExtension("artifactid", artifactId)
				.withExtension("artifactname", artifactName)
				.withExtension("artifactversion", artifactVersion)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createEnvironmentEvent(String envEventType, String envId, String envName,
			String envRepoUrl, String envData) {
		CloudEvent ceToSend = buildCloudEvent(envEventType, envData)
				.withExtension("envid", envId)
				.withExtension("envname", envName)
				.withExtension("envrepourl", envRepoUrl)
				.build();
		return ceToSend;
	}
	
	public static CloudEvent createServiceEvent(String serviceEventType, String serviceId, String serviceName,
			String serviceVersion, String serviceData) {
		CloudEvent ceToSend = buildCloudEvent(serviceEventType, serviceData)
				.withExtension("serviceid", serviceId)
				.withExtension("servicename", serviceName)
				.withExtension("serviceversion", serviceVersion)
				.build();
		return ceToSend;
	}
	
	private static CloudEventBuilder buildCloudEvent(String eventType, String eventData) {
		CloudEventBuilder ceBuilder = new CloudEventBuilder()
				.withId(UUID.randomUUID().toString())
				.withSource(URI.create("cdevents-sdk-java"))
				.withType(eventType)
				.withData(eventData.getBytes(StandardCharsets.UTF_8))
				.withTime(OffsetDateTime.now());
		return ceBuilder;
	}
}
