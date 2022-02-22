package com.kuliginstepan.dadata.client.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

/**
 * Base class for all Jackson DTO's containing map of unparsed properties
 */
@SuppressWarnings("unused")
@SuperBuilder
public class AdditionalProps {

    @JsonAnySetter
    @Singular("additionalProperties")
    private final Map<String, Object> additionalProperties;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
//
//    @JsonAnySetter
//    private void setAdditionalProperties(String name, Object value) {
//        additionalProperties.put(name, value);
//    }

}
