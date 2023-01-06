package dev.cdevents.constants;

public class CDEventConstants {
    
    private static final String version = "0.1.0";
    
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
        PipelineRunStartedEvent("dev.cdevents.pipelinerun.started." + version),
        /**
         * Pipeline run finished event.
         */
        PipelineRunFinishedEvent("dev.cdevents.pipelinerun.finished." + version),
        /**
         * Pipeline run queued event.
         */
        PipelineRunQueuedEvent("dev.cdevents.pipelinerun.queued." + version),

        /* TaskRun events */
        /**
         * Task run started event.
         */
        TaskRunStartedEvent("dev.cdevents.taskrun.started." + version),
        /**
         * Task run finished event.
         */
        TaskRunFinishedEvent("dev.cdevents.taskrun.finished." + version),

        /* Repository events */
        /**
         * Repository created event.
         */
        RepositoryCreatedEvent("dev.cdevents.repository.created." + version),
        /**
         * Repository modified event.
         */
        RepositoryModifiedEvent("dev.cdevents.repository.modified." + version),
        /**
         * Repository deleted event.
         */
        RepositoryDeletedEvent("dev.cdevents.repository.deleted." + version),
        /**
         * Repository branch created event.
         */
        BranchCreatedEvent("dev.cdevents.branch.created." + version),
        /**
         * Repository branch deleted event.
         */
        BranchDeletedEvent("dev.cdevents.branch.deleted." + version),

        /* Repository change Events */
        /**
         * Repository change created event.
         */
        ChangeCreatedEvent("dev.cdevents.change.created." + version),
        /**
         * Repository change updated event.
         */
        ChangeUpdatedEvent("dev.cdevents.change.updated." + version),
        /**
         * Repository change reviewed event.
         */
        ChangeReviewedEvent("dev.cdevents.change.reviewed." + version),
        /**
         * Repository change merged event.
         */
        ChangeMergedEvent("dev.cdevents.change.merged." + version),
        /**
         * Repository change abandoned event.
         */
        ChangeAbandonedEvent("dev.cdevents.change.abandoned." + version),

        /* Build Events */
        /**
         * Build started event.
         */
        BuildStartedEvent("dev.cdevents.build.started" + version),
        /**
         * Build queued event.
         */
        BuildQueuedEvent("dev.cdevents.build.queued" + version),
        /**
         * Build finished event.
         */
        BuildFinishedEvent("dev.cdevents.build.finished" + version),

        /* Test Events */
        /**
         * TestCase started event.
         */
        TestCaseStartedEvent("dev.cdevents.testcase.started" + version),
        /**
         * TestCase queued event.
         */
        TestCaseQueuedEvent("dev.cdevents.testcase.queued" + version),
        /**
         * TestCase finished event.
         */
        TestCaseFinishedEvent("dev.cdevents.testcase.finished" + version),
        /**
         * TestSuite started event.
         */
        TestSuiteStartedEvent("dev.cdevents.testsuite.started" + version),
        /**
         * TestSuite queued event.
         */
        TestSuiteQueuedEvent("dev.cdevents.testsuite.queued" + version),
        /**
         * TestSuite finished event.
         */
        TestSuiteFinishedEvent("dev.cdevents.testsuite.finished" + version),

        /* Artifact Events */
        /**
         * Artifact packaged event.
         */
        ArtifactPackagedEvent("dev.cdevents.artifact.packaged." + version),
        /**
         * Artifact published event.
         */
        ArtifactPublishedEvent("dev.cdevents.artifact.packaged." + version),
        /**
         * Artifact created event.
         */
        ArtifactCreatedEvent("dev.cdevents.artifact.created." + version),

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
