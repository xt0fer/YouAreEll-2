package models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"sequence",
"timestamp",
"fromid",
"toid",
"message"
})
@Generated("jsonschema2pojo")
public class MessagePojo {

@JsonProperty("sequence")
private String sequence;
@JsonProperty("timestamp")
private String timestamp;
@JsonProperty("fromid")
private String fromid;
@JsonProperty("toid")
private String toid;
@JsonProperty("message")
private String message;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("sequence")
public String getSequence() {
return sequence;
}

@JsonProperty("sequence")
public void setSequence(String sequence) {
this.sequence = sequence;
}

@JsonProperty("timestamp")
public String getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

@JsonProperty("fromid")
public String getFromid() {
return fromid;
}

@JsonProperty("fromid")
public void setFromid(String fromid) {
this.fromid = fromid;
}

@JsonProperty("toid")
public String getToid() {
return toid;
}

@JsonProperty("toid")
public void setToid(String toid) {
this.toid = toid;
}

@JsonProperty("message")
public String getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(String message) {
this.message = message;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}