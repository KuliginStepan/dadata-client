package com.kuliginstepan.dadata.client.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all Jackson DTO's containing map of unparsed properties
 */
@SuppressWarnings("unused")
public class AdditionalProps {

    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void setAdditionalProperties(String name, Object value) {
        additionalProperties.put(name, value);
    }

}
