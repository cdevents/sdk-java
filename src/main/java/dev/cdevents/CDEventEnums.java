package dev.cdevents;

	public enum CDEventEnums {
		// PipelineRun events
		PipelineRunStartedEventV1("cd.pipelinerun.started.v1"),
		PipelineRunFinishedEventV1("cd.pipelinerun.finished.v1"), 
		PipelineRunQueuedEventV1("cd.pipelinerun.queued.v1"),
		// TaskRun events
		TaskRunStartedEventV1("cd.taskrun.started.v1"), 
		TaskRunFinishedEventV1("cd.taskrun.finished.v1"),
		// Repository events
		RepositoryCreatedEventV1("cd.repository.created.v1"), 
		RepositoryModifiedEventV1("cd.repository.modified.v1"),
		RepositoryDeletedEventV1("cd.repository.deleted.v1"), 
		BranchCreatedEventV1("cd.repository.branch.created.v1"), 
		BranchDeletedEventV1("cd.repository.branch.deleted.v1"),
		// Repository change Events
		ChangeCreatedEventV1("cd.repository.change.created.v1"), 
		ChangeUpdatedEventV1("cd.repository.change.updated.v1"), 
		ChangeReviewedEventV1("cd.repository.change.reviewed.v1"), 
		ChangeMergedEventV1("cd.repository.change.merged.v1"), 
		ChangeAbandonedEventV1("cd.repository.change.abandoned.v1"),
		// Build Events
		BuildStartedEventV1("cd.build.started.v1"),
		BuildQueuedEventV1("cd.build.queued.v1"),
		BuildFinishedEventV1("cd.build.finished.v1"),

		// Test Events
		TestCaseStartedEventV1("cd.test.case.started.v1"),
		TestCaseQueuedEventV1("cd.test.case.queued.v1"),
		TestCaseFinishedEventV1("cd.test.case.finished.v1"),

		TestSuiteStartedEventV1("cd.test.suite.started.v1"),
		TestSuiteQueuedEventV1("cd.test.suite.queued.v1"),
		TestSuiteFinishedEventV1("cd.test.suite.finished.v1"),

		// Artifact Events
		ArtifactPackagedEventV1("cd.artifact.packaged.v1"),
		ArtifactPublishedEventV1("cd.artifact.published.v1"),
		ArtifactCreatedEventV1("cd.artifact.created.v1"),

		// Environment Events
		EnvironmentCreatedEventV1("cd.environment.created.v1"),
		EnvironmentModifiedEventV1("cd.environment.modified.v1"),
		EnvironmentDeletedEventV1("cd.environment.deleted.v1"),

		// Service Events
		ServiceDeployedEventV1("cd.service.deployed.v1"),
		ServiceUpgradedEventV1("cd.service.upgraded.v1"),
		ServiceRolledbackEventV1("cd.service.rolledback.v1"),
		ServiceRemovedEventV1("cd.service.removed.v1");

		private String eventType;

		CDEventEnums(String eventType) {
			this.eventType = eventType;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
}
