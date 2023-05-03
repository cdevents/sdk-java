package dev.cdevents.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.cdevents.constants.CDEventConstants;

import java.net.URI;

public class RepositorySubject extends Subject {

    @JsonProperty(required = true)
    private RepositorySubjectContent content;


    /**
     * @return the Repository subject's Content
     */
    public RepositorySubjectContent getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(RepositorySubjectContent content) {
        this.content = content;
    }

    /**
     * @param subjectType
     */
    public RepositorySubject(CDEventConstants.SubjectType subjectType) {
        super(subjectType);
        setContent(new RepositorySubjectContent());

    }

    public class RepositorySubjectContent {

        private String name;
        private String owner;
        private URI url;
        private URI viewUrl;


        /**
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return owner
         */
        public String getOwner() {
            return owner;
        }

        /**
         * @param owner
         */
        public void setOwner(String owner) {
            this.owner = owner;
        }

        /**
         * @return url
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
         * @return viewUrl
         */
        public URI getViewUrl() {
            return viewUrl;
        }

        /**
         * @param viewUrl
         */
        public void setViewUrl(URI viewUrl) {
            this.viewUrl = viewUrl;
        }
    }
}
