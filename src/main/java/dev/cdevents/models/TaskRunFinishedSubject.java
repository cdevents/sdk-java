package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class TaskRunFinishedSubject extends Subject {

    @JsonProperty(required = true)
    private TaskRunFinishedSubjectContent content;


    /**
     * @return the TaskRunFinished subject's Content
     */
    public TaskRunFinishedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(TaskRunFinishedSubjectContent content) {
        this.content = content;
    }

    /**
     * Empty constructor.
     */
    public TaskRunFinishedSubject() {
    }

    /**
     * @param subjectType
     */
    public TaskRunFinishedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new TaskRunFinishedSubjectContent());

    }

    public class TaskRunFinishedSubjectContent {

        @JsonProperty
        private String taskName;

        @JsonProperty
        private URI url;

        @JsonProperty
        private CDEventConstants.Outcome outcome;

        @JsonProperty
        private String errors;

        @JsonProperty
        private PipelineRun pipelineRun = new PipelineRun();

        /**
         * @return taskName
         */
        public String getTaskName() {
            return taskName;
        }

        /**
         * @param taskName
         */
        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        /**
         * @return URL
         */
        public URI getUrl() {
            return url;
        }

        /**
         * @param url
         */
        public void setUrl(URI url) {
            this.url = url;
        }

        /**
         * @return outcome
         */
        public CDEventConstants.Outcome getOutcome() {
            return outcome;
        }

        /**
         * @param outcome
         */
        public void setOutcome(CDEventConstants.Outcome outcome) {
            this.outcome = outcome;
        }


        /**
         * @return errors
         */
        public String getErrors() {
            return errors;
        }


        /**
         * @param errors
         */
        public void setErrors(String errors) {
            this.errors = errors;
        }

        /**
         * @return pipelineRun
         */
        public PipelineRun getPipelineRun() {
            return pipelineRun;
        }

        /**
         * @param pipelineRun
         */
        public void setPipelineRun(PipelineRun pipelineRun) {
            this.pipelineRun = pipelineRun;
        }

        public class PipelineRun {
            private String id;

            private URI source;

            /**
             * @return id
             */
            public String getId() {
                return id;
            }

            /**
             * @param id
             */
            public void setId(String id) {
                this.id = id;
            }

            /**
             * @return source
             */
            public URI getSource() {
                return source;
            }

            /**
             * @param source
             */
            public void setSource(URI source) {
                this.source = source;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof PipelineRun)) return false;

                PipelineRun that = (PipelineRun) o;

                if (!getId().equals(that.getId())) return false;
                return getSource() != null ? getSource().equals(that.getSource()) : that.getSource() == null;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TaskRunFinishedSubjectContent)) return false;

            TaskRunFinishedSubjectContent that = (TaskRunFinishedSubjectContent) o;

            if (getTaskName() != null ? !getTaskName().equals(that.getTaskName()) : that.getTaskName() != null)
                return false;
            if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null) return false;
            if (getOutcome() != that.getOutcome()) return false;
            if (getErrors() != null ? !getErrors().equals(that.getErrors()) : that.getErrors() != null) return false;
            return getPipelineRun().equals(that.getPipelineRun());
        }
    }
}
