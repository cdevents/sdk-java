package dev.cdevents.constants;

import dev.cdevents.events.*;

import java.io.File;

public final class CDEventConstants {

    private CDEventConstants() {
    }

    /**
     * Spec repo location.
     */
    public static final String SPEC_REPO = ".." + File.separator + "spec";

    /**
     * Event JsonSchema file system location.
     */
    public static final String SCHEMA_FOLDER = SPEC_REPO + File.separator + "schemas";

    /**
     * Event JsonSchema classpath location.
     */
    public static final String SCHEMA_CLASSPATH = "classpath:dev/cdevents/spec/schemas/";

    /**
     * Event link schemas location.
     */
    public static final String SCHEMA_LINKS_FOLDER = SCHEMA_FOLDER + File.separator + "links";

    /**
     * CDEvents Version.
     */
    public static final String CDEVENTS_SPEC_VERSION = "0.4.0";

    /**
     * CDEvent type prefix.
     */
    public static final String EVENT_PREFIX = "dev.cdevents.";
    /**
     * CDEvent type subject index.
     */
    public static final int EVENT_SUBJECT_INDEX = 2;
    /**
     * CDEvent type predicate index.
     */
    public static final int EVENT_PREDICATE_INDEX = 3;

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
        PipelineRunStartedEvent("dev.cdevents.pipelinerun.started.", PipelinerunStartedCDEvent.class),
        /**
         * Pipeline run finished event.
         */
        PipelineRunFinishedEvent("dev.cdevents.pipelinerun.finished.", PipelinerunFinishedCDEvent.class),
        /**
         * Pipeline run queued event.
         */
        PipelineRunQueuedEvent("dev.cdevents.pipelinerun.queued.", PipelinerunQueuedCDEvent.class),

        /* TaskRun events */
        /**
         * Task run started event.
         */
        TaskRunStartedEvent("dev.cdevents.taskrun.started.", TaskrunStartedCDEvent.class),
        /**
         * Task run finished event.
         */
        TaskRunFinishedEvent("dev.cdevents.taskrun.finished.", TaskrunFinishedCDEvent.class),

        /* Repository events */
        /**
         * Repository created event.
         */
        RepositoryCreatedEvent("dev.cdevents.repository.created.", RepositoryCreatedCDEvent.class),
        /**
         * Repository modified event.
         */
        RepositoryModifiedEvent("dev.cdevents.repository.modified.", RepositoryModifiedCDEvent.class),
        /**
         * Repository deleted event.
         */
        RepositoryDeletedEvent("dev.cdevents.repository.deleted.", RepositoryDeletedCDEvent.class),
        /**
         * Repository branch created event.
         */
        BranchCreatedEvent("dev.cdevents.branch.created.", BranchCreatedCDEvent.class),
        /**
         * Repository branch deleted event.
         */
        BranchDeletedEvent("dev.cdevents.branch.deleted.", BranchDeletedCDEvent.class),

        /* Repository change Events */
        /**
         * Repository change created event.
         */
        ChangeCreatedEvent("dev.cdevents.change.created.", ChangeCreatedCDEvent.class),
        /**
         * Repository change updated event.
         */
        ChangeUpdatedEvent("dev.cdevents.change.updated.", ChangeUpdatedCDEvent.class),
        /**
         * Repository change reviewed event.
         */
        ChangeReviewedEvent("dev.cdevents.change.reviewed.", ChangeReviewedCDEvent.class),
        /**
         * Repository change merged event.
         */
        ChangeMergedEvent("dev.cdevents.change.merged.", ChangeMergedCDEvent.class),
        /**
         * Repository change abandoned event.
         */
        ChangeAbandonedEvent("dev.cdevents.change.abandoned.", ChangeAbandonedCDEvent.class),

        /* Build Events */
        /**
         * Build started event.
         */
        BuildStartedEvent("dev.cdevents.build.started.", BuildStartedCDEvent.class),
        /**
         * Build queued event.
         */
        BuildQueuedEvent("dev.cdevents.build.queued.", BuildQueuedCDEvent.class),
        /**
         * Build finished event.
         */
        BuildFinishedEvent("dev.cdevents.build.finished.", BuildFinishedCDEvent.class),

        /* Test Events */
        /**
         * TestCaseRun started event.
         */
        TestCaseRunStartedEvent("dev.cdevents.testcaserun.started.", TestcaserunStartedCDEvent.class),
        /**
         * TestCaseRun queued event.
         */
        TestCaseRunQueuedEvent("dev.cdevents.testcaserun.queued.", TestcaserunQueuedCDEvent.class),
        /**
         * TestCaseRun skipped event.
         */
        TestCaseRunSkippedEvent("dev.cdevents.testcaserun.skipped.", TestcaserunSkippedCDEvent.class),
        /**
         * TestCaseRun finished event.
         */
        TestCaseRunFinishedEvent("dev.cdevents.testcaserun.finished.", TestcaserunFinishedCDEvent.class),
        /**
         * TestSuiteRun started event.
         */
        TestSuiteRunStartedEvent("dev.cdevents.testsuiterun.started.", TestsuiterunStartedCDEvent.class),
        /**
         * TestSuiteRun queued event.
         */
        TestSuiteRunQueuedEvent("dev.cdevents.testsuiterun.queued.", TestsuiterunQueuedCDEvent.class),
        /**
         * TestSuiteRun finished event.
         */
        TestSuiteRunFinishedEvent("dev.cdevents.testsuiterun.finished.", TestsuiterunFinishedCDEvent.class),

        /**
         * TestOutput published event.
         */
        TestOutputPublishedEvent("dev.cdevents.testoutput.published.", TestoutputPublishedCDEvent.class),

        /* Artifact Events */
        /**
         * Artifact deleted event.
         */
        ArtifactDeletedEvent("dev.cdevents.artifact.deleted.", ArtifactDeletedCDEvent.class),

        /**
         * Artifact downloaded event.
         */
        ArtifactDownloadedEvent("dev.cdevents.artifact.downloaded.", ArtifactDownloadedCDEvent.class),

        /**
         * Artifact packaged event.
         */
        ArtifactPackagedEvent("dev.cdevents.artifact.packaged.", ArtifactPackagedCDEvent.class),
        /**
         * Artifact published event.
         */
        ArtifactPublishedEvent("dev.cdevents.artifact.published.", ArtifactPublishedCDEvent.class),
        /**
         * Artifact signed event.
         */
        ArtifactSignedEvent("dev.cdevents.artifact.signed.", ArtifactSignedCDEvent.class),

        /* Environment Events */
        /**
         * Environment created event.
         */
        EnvironmentCreatedEvent("dev.cdevents.environment.created.", EnvironmentCreatedCDEvent.class),
        /**
         * Environment modified event.
         */
        EnvironmentModifiedEvent("dev.cdevents.environment.modified.", EnvironmentModifiedCDEvent.class),
        /**
         * Environment deleted event.
         */
        EnvironmentDeletedEvent("dev.cdevents.environment.deleted.", EnvironmentDeletedCDEvent.class),

        /* Incident Events */
        /**
         * Incident detected event.
         */
        IncidentDetectedEvent("dev.cdevents.incident.detected.", IncidentDetectedCDEvent.class),

        /**
         * Incident reported event.
         */
        IncidentReportedEvent("dev.cdevents.incident.reported.", IncidentReportedCDEvent.class),

        /**
         * Incident resolved event.
         */
        IncidentResolvedEvent("dev.cdevents.incident.resolved.", IncidentResolvedCDEvent.class),


        /* Service Events */
        /**
         * Service deployed event.
         */
        ServiceDeployedEvent("dev.cdevents.service.deployed.", ServiceDeployedCDEvent.class),
        /**
         * Service upgraded event.
         */
        ServiceUpgradedEvent("dev.cdevents.service.upgraded.", ServiceUpgradedCDEvent.class),
        /**
         * Service rolled back event.
         */
        ServiceRolledBackEvent("dev.cdevents.service.rolledback.", ServiceRolledbackCDEvent.class),
        /**
         * Service removed event.
         */
        ServiceRemovedEvent("dev.cdevents.service.removed.", ServiceRemovedCDEvent.class),
        /**
         * Service published event.
         */
        ServicePublishedEvent("dev.cdevents.service.published.", ServicePublishedCDEvent.class),

        /* Ticket Events */
        /**
         * Ticket closed event.
         */
        TicketClosedEvent("dev.cdevents.ticket.closed.", TicketClosedCDEvent.class),
        /**
         * Ticket created event.
         */
        TicketCreatedEvent("dev.cdevents.ticket.created.", TicketCreatedCDEvent.class),
        /**
         * Ticket updated event.
         */
        TicketUpdatedEvent("dev.cdevents.ticket.updated.", TicketUpdatedCDEvent.class);

        /**
         * Continuous delivery event type.
         */
        private String eventType;

        private Class eventClass;

        CDEventTypes(final String event, final Class eventClass) {
            this.eventType = event;
            this.eventClass = eventClass;
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

        /**
         * @return class name of the event type
         */
        public Class getEventClass() {
            return eventClass;
        }

        /**
         * @param eventClass class name to set
         */
        public void setEventClass(Class eventClass) {
            this.eventClass = eventClass;
        }
    }
}
