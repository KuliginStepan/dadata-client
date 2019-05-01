package com.kuliginstepan.dadata.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.domain.DadataRequest;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class AddressDadataRequest extends DadataRequest {

    @JsonProperty("locations_boost")
    private List<Map<String, String>> locationsBoost;
    private List<Map<String, String>> locations;
    @JsonProperty("from_bound")
    private Map<String, String> fromBound;
    @JsonProperty("to_bound")
    private Map<String, String> toBound;
    @JsonProperty("restrict_value")
    private Boolean restrictValue;

    public AddressDadataRequest(String query,
        Integer count,
        List<Map<String, String>> locationsBoost,
        List<Map<String, String>> locations, Map<String, String> fromBound,
        Map<String, String> toBound, Boolean restrictValue) {
        super(query, count);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.fromBound = fromBound;
        this.toBound = toBound;
        this.restrictValue = restrictValue;
    }
}
