package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class ArtifactPackagedSubject extends Subject {

    @JsonProperty(required = true)
    private ArtifactPackagedSubjectContent content = new ArtifactPackagedSubjectContent();

    /**
     * @return the Artifact subject's Content
     */
    public ArtifactPackagedSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(ArtifactPackagedSubjectContent content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
    public ArtifactPackagedSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new ArtifactPackagedSubjectContent());
    }

    public class ArtifactPackagedSubjectContent {
        private Change change = new Change();

        /**
         * @return change
         */
        public Change getChange() {
            return change;
        }

        /**
         * @param change
         */
        public void setChange(Change change) {
            this.change = change;
        }

        public class Change {
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
        }
    }

}
