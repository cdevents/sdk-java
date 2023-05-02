package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class BranchSubject extends Subject {

    @JsonProperty(required = true)
    private BranchSubjectContent content;


    /**
     * @return the Branch/Change subject's Content
     */
    public BranchSubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(BranchSubjectContent content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
    public BranchSubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new BranchSubjectContent());

    }

    public class BranchSubjectContent {

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
