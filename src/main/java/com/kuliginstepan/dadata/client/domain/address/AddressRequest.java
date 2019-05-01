package com.kuliginstepan.dadata.client.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.List;
import java.util.Map;
import lombok.Getter;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669107">Dadata address suggestion docs</a>
 */

@Getter
public class AddressRequest extends BasicRequest {

    @JsonProperty("locations_boost")
    private List<Map<FilterProperty, String>> locationsBoost;
    private List<Map<FilterProperty, String>> locations;
    @JsonProperty("from_bound")
    private Map<String, String> fromBound;
    @JsonProperty("to_bound")
    private Map<String, String> toBound;
    @JsonProperty("restrict_value")
    private Boolean restrictValue;

    public AddressRequest(String query,
        Integer count,
        List<Map<FilterProperty, String>> locationsBoost,
        List<Map<FilterProperty, String>> locations, Map<String, String> fromBound,
        Map<String, String> toBound, Boolean restrictValue) {
        super(query, count);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.fromBound = fromBound;
        this.toBound = toBound;
        this.restrictValue = restrictValue;
    }
}
