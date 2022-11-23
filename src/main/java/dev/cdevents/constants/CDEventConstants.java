package dev.cdevents.constants;

public class CDEventConstants {
    public enum Outcome {
        OutcomeSuccess("success"),
        OutcomeFailure("failure"),
        OutcomeError("error");

        private String outcome;
        Outcome(final String outcome){this.outcome = outcome;}

        public String getOutcome() {
            return outcome;
        }

        public void setOutcome(String outcome) {
            this.outcome = outcome;
        }
    }

    public enum CDEventTypes {


        /* PipelineRun events */
        /**
         * Pipeline run started event.
         */
        PipelineRunStartedEvent("dev.cdevents.pipelinerun.started." + getVersion()),
        /**
         * Pipeline run finished event.
         */
        PipelineRunFinishedEvent("dev.cdevents.pipelinerun.finished." + getVersion()),
        /**
         * Pipeline run queued event.
         */
        PipelineRunQueuedEvent("dev.cdevents.pipelinerun.queued." + getVersion()),

        /* TaskRun events */
        /**
         * Task run started event.
         */
        TaskRunStartedEventV1("cd.taskrun.started.v1"),
        /**
         * Task run finished event.
         */
        TaskRunFinishedEventV1("cd.taskrun.finished.v1"),

        /* Repository events */
        /**
         * Repository created event.
         */
        RepositoryCreatedEventV1("cd.repository.created.v1"),
        /**
         * Repository modified event.
         */
        RepositoryModifiedEventV1("cd.repository.modified.v1"),
        /**
         * Repository deleted event.
         */
        RepositoryDeletedEventV1("cd.repository.deleted.v1"),
        /**
         * Repository branch created event.
         */
        BranchCreatedEventV1("cd.repository.branch.created.v1"),
        /**
         * Repository branch deleted event.
         */
        BranchDeletedEventV1("cd.repository.branch.deleted.v1"),

        /* Repository change Events */
        /**
         * Repository change created event.
         */
        ChangeCreatedEventV1("cd.repository.change.created.v1"),
        /**
         * Repository change updated event.
         */
        ChangeUpdatedEventV1("cd.repository.change.updated.v1"),
        /**
         * Repository change reviewed event.
         */
        ChangeReviewedEventV1("cd.repository.change.reviewed.v1"),
        /**
         * Repository change merged event.
         */
        ChangeMergedEventV1("cd.repository.change.merged.v1"),
        /**
         * Repository change abandoned event.
         */
        ChangeAbandonedEventV1("cd.repository.change.abandoned.v1"),

        /* Build Events */
        /**
         * Build started event.
         */
        BuildStartedEventV1("cd.build.started.v1"),
        /**
         * Build queued event.
         */
        BuildQueuedEventV1("cd.build.queued.v1"),
        /**
         * Build finished event.
         */
        BuildFinishedEventV1("cd.build.finished.v1"),

        /* Test Events */
        /**
         * TestCase started event.
         */
        TestCaseStartedEventV1("cd.test.case.started.v1"),
        /**
         * TestCase queued event.
         */
        TestCaseQueuedEventV1("cd.test.case.queued.v1"),
        /**
         * TestCase finished event.
         */
        TestCaseFinishedEventV1("cd.test.case.finished.v1"),
        /**
         * TestSuite started event.
         */
        TestSuiteStartedEventV1("cd.test.suite.started.v1"),
        /**
         * TestSuite queued event.
         */
        TestSuiteQueuedEventV1("cd.test.suite.queued.v1"),
        /**
         * TestSuite finished event.
         */
        TestSuiteFinishedEventV1("cd.test.suite.finished.v1"),

        /* Artifact Events */
        /**
         * Artifact packaged event.
         */
        ArtifactPackagedEventV1("cd.artifact.packaged.v1"),
        /**
         * Artifact published event.
         */
        ArtifactPublishedEventV1("cd.artifact.published.v1"),
        /**
         * Artifact created event.
         */
        ArtifactCreatedEventV1("cd.artifact.created.v1"),

        /* Environment Events */
        /**
         * Environment created event.
         */
        EnvironmentCreatedEventV1("cd.environment.created.v1"),
        /**
         * Environment modified event.
         */
        EnvironmentModifiedEventV1("cd.environment.modified.v1"),
        /**
         * Environment deleted event.
         */
        EnvironmentDeletedEventV1("cd.environment.deleted.v1"),

        /* Service Events */
        /**
         * Service deployed event.
         */
        ServiceDeployedEventV1("cd.service.deployed.v1"),
        /**
         * Service upgraded event.
         */
        ServiceUpgradedEventV1("cd.service.upgraded.v1"),
        /**
         * Service rolled back event.
         */
        ServiceRolledbackEventV1("cd.service.rolledback.v1"),
        /**
         * Service removed event.
         */
        ServiceRemovedEventV1("cd.service.removed.v1");


        private static String getVersion() {
            return "0.1.0";
        }

        /**
         * Continuous delivery event type.
         */
        private String eventType;

        CDEventTypes(final String event) {
            this.eventType = event;
        }

        /**
         * @return the continuous delivery event type
         */
        public String getEventType() {
            return eventType;
        }

        /**
         * @param event the continuous delivery event type to set
         */
        public void setEventType(final String event) {
            this.eventType = event;
        }


    }
}
