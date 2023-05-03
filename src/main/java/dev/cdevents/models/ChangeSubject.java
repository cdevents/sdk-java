package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class ChangeSubject extends Subject {

    @JsonProperty(required = true)
    private ChangeSubjectContent content;


    /**
     * @return the Change subject's Content
     */
    public ChangeSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(ChangeSubjectContent content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
    public ChangeSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new ChangeSubjectContent());

    }

    public class ChangeSubjectContent {

       private Repository repository = new Repository();

        /**
         * @return repository
         */
        public Repository getRepository() {
            return repository;
        }

        /**
         * @param repository
         */
        public void setRepository(Repository repository) {
            this.repository = repository;
        }

        public class Repository {
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
