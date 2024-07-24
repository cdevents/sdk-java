// Code generated by dev.cdevents.generator.CDEventsGenerator. DO NOT EDIT.

/*
Copyright 2023 The CDEvents Authors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

SPDX-License-Identifier: Apache-2.0
*/

package dev.cdevents.events;


import dev.cdevents.constants.CDEventConstants;
import dev.cdevents.models.CDEvent;
import dev.cdevents.models.custom.*;
import java.util.Map;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import java.util.List;

public class CustomTypeEvent extends Schema implements CDEvent {


    /**
    * Constructor to init CustomTypeEvent.
    */

    public CustomTypeEvent() {
        initCDEvent();
    }


    /**
    * Initialize the CDEvent with the context values.
    */

    @Override
    public void initCDEvent() {
        setContext(new Context());
        setSubject(new Subject());
        setCustomData(new Object());
        setCustomDataContentType("application/json");
        Context context = getContext();
        context.setId(UUID.randomUUID().toString());
        context.setTimestamp(new Date());
        context.setVersion(CDEventConstants.CDEVENTS_SPEC_VERSION);
        getSubject().setContent(new Content());
    }

    /**
    * @return the event source
    */

    @Override
    public String eventSource() {
        return getContext().getSource();
    }


    /**
    * @return the current CDEvent type
    */

    @Override
    public String currentCDEventType() {
        return getContext().getType();
    }


    /**
    * @return the schema.json schema URL
    */

    @Override
    public String schemaURL() {
        return "https://cdevents.dev/0.4.1/schema/custom";
    }

    /**
    * @return the base URI of the schema
    */

    @Override
    public String baseURI() {
        return "https://cdevents.dev/0.4.1/schema/";
    }


    /**
    * @return the CDEvent's schema file name
    */

    @Override
    public String schemaFileName() {
        return "schema.json";
    }

    /**
    *
    * @return context schema URI
    */
    @Override
    public URI contextSchemaUri() {
        return getContext().getSchemaUri();
    }


    /**
    * @param source
    * Sets the {@link Context} source value
    */

    public void setSource(URI source) {
        getContext().setSource(source.toString());
    }

    /**
     * @param chainId
     * Sets the {@link Context} chainId value
     */

    public void setChainId(String chainId) {
        getContext().setChainId(chainId);
    }

    /**
     * @param schemaUri
     * Sets the {@link Context} custom schemaUri value
     */

    public void setContextSchemaUri(URI schemaUri) {
        getContext().setSchemaUri(schemaUri);
    }

    /**
    * @param subjectId
    * sets the subject Id
    */

    public void setSubjectId(String subjectId) {
        getSubject().setId(subjectId);
    }


    /**
    * @param subjectSource
    * sets the subject source
    */

    public void setSubjectSource(URI subjectSource) {
        getSubject().setSource(subjectSource.toString());
    }

    /**
    * @param type
    * Sets the {@link Context} type value,
    * must be in the format dev.cdeventsx.<tool-name>-<subject-name>.<predicate-name>.<major.minor.patch>
    */

    public void setType(String type) {
        getContext().setType(type);
    }

    /**
    * @param subjectType
    * sets the subject type, must be in the format <tool-name>-<subject-name>
    */
    public void setSubjectType(String subjectType) {
        getSubject().setType(subjectType);
    }

    /**
    * @param contentProperty
    * sets the subject content custom properties
    */
    public void setSubjectContentProperty(Map<String, Object> contentProperty) {
        contentProperty.forEach((key, value) -> getSubject().getContent().setAdditionalProperty(key, value));
    }

}
