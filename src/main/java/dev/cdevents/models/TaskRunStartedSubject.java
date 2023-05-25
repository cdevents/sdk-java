package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class TaskRunStartedSubject extends Subject {

    @JsonProperty(required = true)
    private TaskRunStartedSubjectContent content;


    /**
     * @return the TaskRunStarted subject's Content
     */
    public TaskRunStartedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(TaskRunStartedSubjectContent content) {
        this.content = content;
    }

    /**
     * Empty constructor.
     */
    public TaskRunStartedSubject() {
    }

    /**
     * @param subjectType
     */
    public TaskRunStartedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new TaskRunStartedSubjectContent());

    }

    public class TaskRunStartedSubjectContent {

        @JsonProperty
        private String taskName;

        @JsonProperty
        private URI url;

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
            if (!(o instanceof TaskRunStartedSubjectContent)) return false;

            TaskRunStartedSubjectContent that = (TaskRunStartedSubjectContent) o;

            if (getTaskName() != null ? !getTaskName().equals(that.getTaskName()) : that.getTaskName() != null)
                return false;
            if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null) return false;
            return getPipelineRun().equals(that.getPipelineRun());
        }
    }
}
