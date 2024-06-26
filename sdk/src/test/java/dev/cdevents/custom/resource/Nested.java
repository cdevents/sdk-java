
package dev.cdevents.custom.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "list"
})
@Generated("jsonschema2pojo")
public class Nested {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    private String key;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("list")
    private List<String> list = new ArrayList<String>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("list")
    public List<String> getList() {
        return list;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("list")
    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.list == null)? 0 :this.list.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Nested) == false) {
            return false;
        }
        Nested rhs = ((Nested) other);
        return (((this.list == rhs.list)||((this.list!= null)&&this.list.equals(rhs.list)))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))));
    }

}
