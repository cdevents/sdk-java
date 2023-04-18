package dev.cdevents.constants;

public class CDEventConstants {


    /**
     * CDEvents Version.
     */
    private static final String VERSION = "0.1.0";

    public enum Outcome {
        /**
         * Outcome Success.
         */
        OutcomeSuccess("success"),
        /**
         * Outcome Failure.
         */
        OutcomeFailure("failure"),
        /**
         * Outcome Error.
         */
        OutcomeError("error");

        /**
         *  Outcome.
         */
        private String outcome;

        Outcome(final String outcome) {
            this.outcome = outcome;
        }

        /**
         * @return outcome
         */
        public String getOutcome() {
            return outcome;
        }

        /**
         * @param outcome
         */
        public final void setOutcome(final String outcome) {
            this.outcome = outcome;
        }
    }

    public enum CDEventTypes {

        /* PipelineRun events */
        /**
         * Pipeline run started event.
         */
        PipelineRunStartedEvent("dev.cdevents.pipelinerun.started." + VERSION),
        /**
         * Pipeline run finished event.
         */
        PipelineRunFinishedEvent("dev.cdevents.pipelinerun.finished."
                + VERSION),
        /**
         * Pipeline run queued event.
         */
        PipelineRunQueuedEvent("dev.cdevents.pipelinerun.queued." + VERSION),

        /* TaskRun events */
        /**
         * Task run started event.
         */
        TaskRunStartedEvent("dev.cdevents.taskrun.started." + VERSION),
        /**
         * Task run finished event.
         */
        TaskRunFinishedEvent("dev.cdevents.taskrun.finished." + VERSION),

        /* Repository events */
        /**
         * Repository created event.
         */
        RepositoryCreatedEvent("dev.cdevents.repository.created." + VERSION),
        /**
         * Repository modified event.
         */
        RepositoryModifiedEvent("dev.cdevents.repository.modified." + VERSION),
        /**
         * Repository deleted event.
         */
        RepositoryDeletedEvent("dev.cdevents.repository.deleted." + VERSION),
        /**
         * Repository branch created event.
         */
        BranchCreatedEvent("dev.cdevents.branch.created." + VERSION),
        /**
         * Repository branch deleted event.
         */
        BranchDeletedEvent("dev.cdevents.branch.deleted." + VERSION),

        /* Repository change Events */
        /**
         * Repository change created event.
         */
        ChangeCreatedEvent("dev.cdevents.change.created." + VERSION),
        /**
         * Repository change updated event.
         */
        ChangeUpdatedEvent("dev.cdevents.change.updated." + VERSION),
        /**
         * Repository change reviewed event.
         */
        ChangeReviewedEvent("dev.cdevents.change.reviewed." + VERSION),
        /**
         * Repository change merged event.
         */
        ChangeMergedEvent("dev.cdevents.change.merged." + VERSION),
        /**
         * Repository change abandoned event.
         */
        ChangeAbandonedEvent("dev.cdevents.change.abandoned." + VERSION),

        /* Build Events */
        /**
         * Build started event.
         */
        BuildStartedEvent("dev.cdevents.build.started." + VERSION),
        /**
         * Build queued event.
         */
        BuildQueuedEvent("dev.cdevents.build.queued." + VERSION),
        /**
         * Build finished event.
         */
        BuildFinishedEvent("dev.cdevents.build.finished." + VERSION),

        /* Test Events */
        /**
         * TestCase started event.
         */
        TestCaseStartedEvent("dev.cdevents.testcase.started." + VERSION),
        /**
         * TestCase queued event.
         */
        TestCaseQueuedEvent("dev.cdevents.testcase.queued." + VERSION),
        /**
         * TestCase finished event.
         */
        TestCaseFinishedEvent("dev.cdevents.testcase.finished." + VERSION),
        /**
         * TestSuite started event.
         */
        TestSuiteStartedEvent("dev.cdevents.testsuite.started." + VERSION),
        /**
         * TestSuite queued event.
         */
        TestSuiteQueuedEvent("dev.cdevents.testsuite.queued." + VERSION),
        /**
         * TestSuite finished event.
         */
        TestSuiteFinishedEvent("dev.cdevents.testsuite.finished." + VERSION),

        /* Artifact Events */
        /**
         * Artifact packaged event.
         */
        ArtifactPackagedEvent("dev.cdevents.artifact.packaged." + VERSION),
        /**
         * Artifact published event.
         */
        ArtifactPublishedEvent("dev.cdevents.artifact.packaged." + VERSION),
        /**
         * Artifact created event.
         */
        ArtifactCreatedEvent("dev.cdevents.artifact.created." + VERSION),

        /* Environment Events */
        /**
         * Environment created event.
         */
        EnvironmentCreatedEvent("dev.cdevents.environment.created." + VERSION),
        /**
         * Environment modified event.
         */
        EnvironmentModifiedEvent("dev.cdevents.environment.modified."
                + VERSION),
        /**
         * Environment deleted event.
         */
        EnvironmentDeletedEvent("dev.cdevents.environment.deleted." + VERSION),

        /* Service Events */
        /**
         * Service deployed event.
         */
        ServiceDeployedEvent("dev.cdevents.service.deployed." + VERSION),
        /**
         * Service upgraded event.
         */
        ServiceUpgradedEvent("dev.cdevents.service.upgraded." + VERSION),
        /**
         * Service rolled back event.
         */
        ServiceRolledBackEvent("dev.cdevents.service.rolledback." + VERSION),
        /**
         * Service removed event.
         */
        ServiceRemovedEvent("dev.cdevents.service.removed." + VERSION),
        /**
         * Service published event.
         */
        ServicePublishedEvent("dev.cdevents.service.published." + VERSION);


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
