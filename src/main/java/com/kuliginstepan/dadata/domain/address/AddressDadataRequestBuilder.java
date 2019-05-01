package com.kuliginstepan.dadata.domain.address;


import com.kuliginstepan.dadata.domain.DadataRequestBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressDadataRequestBuilder extends DadataRequestBuilder<AddressDadataRequest> {

    private List<Map<String, String>> locations = new ArrayList<>();
    private Map<String, String> fromBound = new HashMap<>();
    private Map<String, String> toBound = new HashMap<>();
    private Boolean restrictValue = false;

    public static AddressDadataRequestBuilder create(String query) {
        return new AddressDadataRequestBuilder(query);
    }

    protected AddressDadataRequestBuilder(String query) {
        super(query);
    }

    public AddressDadataRequestBuilder location(String key, String value) {
        locations.add(Collections.singletonMap(key, value));
        return this;
    }

    public AddressDadataRequestBuilder fromBound(Bound bound) {
        fromBound.put("value", bound.name().toLowerCase());
        return this;
    }

    public AddressDadataRequestBuilder toBound(Bound bound) {
        toBound.put("value", bound.name().toLowerCase());
        return this;
    }

    public AddressDadataRequestBuilder restrictValue() {
        restrictValue = true;
        return this;
    }

    @Override
    public AddressDadataRequest build() {
        return new AddressDadataRequest(super.query, super.count, super.locationsBoost, locations, fromBound, toBound,
            restrictValue);
    }
}
