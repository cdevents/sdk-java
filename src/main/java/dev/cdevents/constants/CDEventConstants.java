package dev.cdevents.constants;

public class CDEventConstants {


    /**
     * CDEvents Version.
     */
    public static final String CDEVENTS_SPEC_VERSION = "0.1.0";

    public enum SubjectType {
        PIPELINERUN("pipelineRun");

        private String subjectType;

        SubjectType(String subjectType) {
            this.subjectType = subjectType;
        }

        public String getSubjectType() {
            return subjectType;
        }

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
        PipelineRunStartedEvent("dev.cdevents.pipelinerun.started." + CDEVENTS_SPEC_VERSION),
        /**
         * Pipeline run finished event.
         */
        PipelineRunFinishedEvent("dev.cdevents.pipelinerun.finished."
                + CDEVENTS_SPEC_VERSION),
        /**
         * Pipeline run queued event.
         */
        PipelineRunQueuedEvent("dev.cdevents.pipelinerun.queued." + CDEVENTS_SPEC_VERSION),

        /* TaskRun events */
        /**
         * Task run started event.
         */
        TaskRunStartedEvent("dev.cdevents.taskrun.started." + CDEVENTS_SPEC_VERSION),
        /**
         * Task run finished event.
         */
        TaskRunFinishedEvent("dev.cdevents.taskrun.finished." + CDEVENTS_SPEC_VERSION),

        /* Repository events */
        /**
         * Repository created event.
         */
        RepositoryCreatedEvent("dev.cdevents.repository.created." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository modified event.
         */
        RepositoryModifiedEvent("dev.cdevents.repository.modified." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository deleted event.
         */
        RepositoryDeletedEvent("dev.cdevents.repository.deleted." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository branch created event.
         */
        BranchCreatedEvent("dev.cdevents.branch.created." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository branch deleted event.
         */
        BranchDeletedEvent("dev.cdevents.branch.deleted." + CDEVENTS_SPEC_VERSION),

        /* Repository change Events */
        /**
         * Repository change created event.
         */
        ChangeCreatedEvent("dev.cdevents.change.created." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository change updated event.
         */
        ChangeUpdatedEvent("dev.cdevents.change.updated." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository change reviewed event.
         */
        ChangeReviewedEvent("dev.cdevents.change.reviewed." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository change merged event.
         */
        ChangeMergedEvent("dev.cdevents.change.merged." + CDEVENTS_SPEC_VERSION),
        /**
         * Repository change abandoned event.
         */
        ChangeAbandonedEvent("dev.cdevents.change.abandoned." + CDEVENTS_SPEC_VERSION),

        /* Build Events */
        /**
         * Build started event.
         */
        BuildStartedEvent("dev.cdevents.build.started" + CDEVENTS_SPEC_VERSION),
        /**
         * Build queued event.
         */
        BuildQueuedEvent("dev.cdevents.build.queued" + CDEVENTS_SPEC_VERSION),
        /**
         * Build finished event.
         */
        BuildFinishedEvent("dev.cdevents.build.finished" + CDEVENTS_SPEC_VERSION),

        /* Test Events */
        /**
         * TestCase started event.
         */
        TestCaseStartedEvent("dev.cdevents.testcase.started" + CDEVENTS_SPEC_VERSION),
        /**
         * TestCase queued event.
         */
        TestCaseQueuedEvent("dev.cdevents.testcase.queued" + CDEVENTS_SPEC_VERSION),
        /**
         * TestCase finished event.
         */
        TestCaseFinishedEvent("dev.cdevents.testcase.finished" + CDEVENTS_SPEC_VERSION),
        /**
         * TestSuite started event.
         */
        TestSuiteStartedEvent("dev.cdevents.testsuite.started" + CDEVENTS_SPEC_VERSION),
        /**
         * TestSuite queued event.
         */
        TestSuiteQueuedEvent("dev.cdevents.testsuite.queued" + CDEVENTS_SPEC_VERSION),
        /**
         * TestSuite finished event.
         */
        TestSuiteFinishedEvent("dev.cdevents.testsuite.finished" + CDEVENTS_SPEC_VERSION),

        /* Artifact Events */
        /**
         * Artifact packaged event.
         */
        ArtifactPackagedEvent("dev.cdevents.artifact.packaged." + CDEVENTS_SPEC_VERSION),
        /**
         * Artifact published event.
         */
        ArtifactPublishedEvent("dev.cdevents.artifact.packaged." + CDEVENTS_SPEC_VERSION),
        /**
         * Artifact created event.
         */
        ArtifactCreatedEvent("dev.cdevents.artifact.created." + CDEVENTS_SPEC_VERSION),

        /* Environment Events */
        /**
         * Environment created event.
         */
        EnvironmentCreatedEvent("dev.cdevents.environment.created." + CDEVENTS_SPEC_VERSION),
        /**
         * Environment modified event.
         */
        EnvironmentModifiedEvent("dev.cdevents.environment.modified."
                + CDEVENTS_SPEC_VERSION),
        /**
         * Environment deleted event.
         */
        EnvironmentDeletedEvent("dev.cdevents.environment.deleted." + CDEVENTS_SPEC_VERSION),

        /* Service Events */
        /**
         * Service deployed event.
         */
        ServiceDeployedEvent("dev.cdevents.service.deployed." + CDEVENTS_SPEC_VERSION),
        /**
         * Service upgraded event.
         */
        ServiceUpgradedEvent("dev.cdevents.service.upgraded." + CDEVENTS_SPEC_VERSION),
        /**
         * Service rolled back event.
         */
        ServiceRolledBackEvent("dev.cdevents.service.rolledback." + CDEVENTS_SPEC_VERSION),
        /**
         * Service removed event.
         */
        ServiceRemovedEvent("dev.cdevents.service.removed." + CDEVENTS_SPEC_VERSION),
        /**
         * Service published event.
         */
        ServicePublishedEvent("dev.cdevents.service.published." + CDEVENTS_SPEC_VERSION);


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
