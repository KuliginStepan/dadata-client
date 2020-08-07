package com.kuliginstepan.dadata.client.domain.address;


import com.kuliginstepan.dadata.client.domain.RequestBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressRequestBuilder extends RequestBuilder<AddressRequest> {

    private List<Map<FilterProperty, String>> locations = new ArrayList<>();
    private Map<String, String> fromBound = new HashMap<>();
    private Map<String, String> toBound = new HashMap<>();
    private Boolean restrictValue = false;
    private String language;

    public static AddressRequestBuilder create(String query) {
        return new AddressRequestBuilder(query);
    }

    protected AddressRequestBuilder(String query) {
        super(query);
    }

    public AddressRequestBuilder location(FilterProperty filter, String value) {
        locations.add(Collections.singletonMap(filter, value));
        return this;
    }

    public AddressRequestBuilder fromBound(Bound bound) {
        fromBound.put("value", bound.name().toLowerCase());
        return this;
    }

    public AddressRequestBuilder toBound(Bound bound) {
        toBound.put("value", bound.name().toLowerCase());
        return this;
    }

    public AddressRequestBuilder restrictValue() {
        restrictValue = true;
        return this;
    }

    public AddressRequestBuilder outputLanguage(String language) {
        this.language = language;
        return this;
    }


    @Override
    public AddressRequest build() {
        return new AddressRequest(super.query, super.count, super.locationsBoost, locations, fromBound, toBound,
            restrictValue, language);
    }
}
