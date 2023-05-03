package dev.cdevents.constants;

public final class CDEventConstants {

    private CDEventConstants() {
    }

    /**
     * CDEvents Version.
     */
    public static final String CDEVENTS_SPEC_VERSION = "0.1.2";

    public enum SubjectType {

        /**
         * Subject Type taskRun.
         */
        TASKRUN("taskRun"),
        /**
         * Subject Type pipelineRun.
         */
        PIPELINERUN("pipelineRun");

        private String subjectType;

        /**
         * @param subjectType
         */
        SubjectType(String subjectType) {
            this.subjectType = subjectType;
        }

        /**
         * @return subjectType
         */
        public String getSubjectType() {
            return subjectType;
        }

        /**
         * @param subjectType
         */
        public void setSubjectType(String subjectType) {
            this.subjectType = subjectType;
        }
    }

    public enum Outcome {
        /**
         * Outcome Success.
         */
        SUCCESS("success"),
        /**
         * Outcome Failure.
         */
        FAILURE("failure"),
        /**
         * Outcome Error.
         */
        ERROR("error");

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
        PipelineRunStartedEvent("dev.cdevents.pipelinerun.started."),
        /**
         * Pipeline run finished event.
         */
        PipelineRunFinishedEvent("dev.cdevents.pipelinerun.finished."),
        /**
         * Pipeline run queued event.
         */
        PipelineRunQueuedEvent("dev.cdevents.pipelinerun.queued."),

        /* TaskRun events */
        /**
         * Task run started event.
         */
        TaskRunStartedEvent("dev.cdevents.taskrun.started."),
        /**
         * Task run finished event.
         */
        TaskRunFinishedEvent("dev.cdevents.taskrun.finished."),

        /* Repository events */
        /**
         * Repository created event.
         */
        RepositoryCreatedEvent("dev.cdevents.repository.created."),
        /**
         * Repository modified event.
         */
        RepositoryModifiedEvent("dev.cdevents.repository.modified."),
        /**
         * Repository deleted event.
         */
        RepositoryDeletedEvent("dev.cdevents.repository.deleted."),
        /**
         * Repository branch created event.
         */
        BranchCreatedEvent("dev.cdevents.branch.created."),
        /**
         * Repository branch deleted event.
         */
        BranchDeletedEvent("dev.cdevents.branch.deleted."),

        /* Repository change Events */
        /**
         * Repository change created event.
         */
        ChangeCreatedEvent("dev.cdevents.change.created."),
        /**
         * Repository change updated event.
         */
        ChangeUpdatedEvent("dev.cdevents.change.updated."),
        /**
         * Repository change reviewed event.
         */
        ChangeReviewedEvent("dev.cdevents.change.reviewed."),
        /**
         * Repository change merged event.
         */
        ChangeMergedEvent("dev.cdevents.change.merged."),
        /**
         * Repository change abandoned event.
         */
        ChangeAbandonedEvent("dev.cdevents.change.abandoned."),

        /* Build Events */
        /**
         * Build started event.
         */
        BuildStartedEvent("dev.cdevents.build.started."),
        /**
         * Build queued event.
         */
        BuildQueuedEvent("dev.cdevents.build.queued."),
        /**
         * Build finished event.
         */
        BuildFinishedEvent("dev.cdevents.build.finished."),

        /* Test Events */
        /**
         * TestCase started event.
         */
        TestCaseStartedEvent("dev.cdevents.testcase.started."),
        /**
         * TestCase queued event.
         */
        TestCaseQueuedEvent("dev.cdevents.testcase.queued."),
        /**
         * TestCase finished event.
         */
        TestCaseFinishedEvent("dev.cdevents.testcase.finished."),
        /**
         * TestSuite started event.
         */
        TestSuiteStartedEvent("dev.cdevents.testsuite.started."),
        /**
         * TestSuite queued event.
         */
        TestSuiteQueuedEvent("dev.cdevents.testsuite.queued."),
        /**
         * TestSuite finished event.
         */
        TestSuiteFinishedEvent("dev.cdevents.testsuite.finished."),

        /* Artifact Events */
        /**
         * Artifact packaged event.
         */
        ArtifactPackagedEvent("dev.cdevents.artifact.packaged."),
        /**
         * Artifact published event.
         */
        ArtifactPublishedEvent("dev.cdevents.artifact.published."),
        /**
         * Artifact created event.
         */
        ArtifactCreatedEvent("dev.cdevents.artifact.created."),

        /* Environment Events */
        /**
         * Environment created event.
         */
        EnvironmentCreatedEvent("dev.cdevents.environment.created."),
        /**
         * Environment modified event.
         */
        EnvironmentModifiedEvent("dev.cdevents.environment.modified."),
        /**
         * Environment deleted event.
         */
        EnvironmentDeletedEvent("dev.cdevents.environment.deleted."),

        /* Service Events */
        /**
         * Service deployed event.
         */
        ServiceDeployedEvent("dev.cdevents.service.deployed."),
        /**
         * Service upgraded event.
         */
        ServiceUpgradedEvent("dev.cdevents.service.upgraded."),
        /**
         * Service rolled back event.
         */
        ServiceRolledBackEvent("dev.cdevents.service.rolledback."),
        /**
         * Service removed event.
         */
        ServiceRemovedEvent("dev.cdevents.service.removed."),
        /**
         * Service published event.
         */
        ServicePublishedEvent("dev.cdevents.service.published.");


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
