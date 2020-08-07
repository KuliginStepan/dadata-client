package com.kuliginstepan.dadata.client.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=262996078">Dadata address suggestion docs</a>
 * @see com.kuliginstepan.dadata.client.domain.address.AddressRequestBuilder
 */

@Value
@EqualsAndHashCode(callSuper = true)
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
    @JsonProperty("language")
    private String language;


    public AddressRequest(String query,
        Integer count,
        List<Map<FilterProperty, String>> locationsBoost,
        List<Map<FilterProperty, String>> locations, Map<String, String> fromBound,
        Map<String, String> toBound, Boolean restrictValue, String language) {
        super(query, count);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.fromBound = fromBound;
        this.toBound = toBound;
        this.restrictValue = restrictValue;
        this.language = language;
    }
}
