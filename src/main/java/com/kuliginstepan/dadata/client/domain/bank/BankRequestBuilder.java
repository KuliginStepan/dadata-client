package com.kuliginstepan.dadata.client.domain.bank;


import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.domain.RequestBuilder;
import com.kuliginstepan.dadata.client.domain.address.FilterProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BankRequestBuilder extends RequestBuilder<BankRequest> {

    private List<Map<FilterProperty, String>> locations = new ArrayList<>();
    private Set<OrganizationStatus> statuses = EnumSet.allOf(OrganizationStatus.class);
    private Set<BankType> types = EnumSet.allOf(BankType.class);

    public static BankRequestBuilder create(String query) {
        return new BankRequestBuilder(query);
    }

    protected BankRequestBuilder(String query) {
        super(query);
    }

    public BankRequestBuilder location(String kladrId) {
        locations.add(Collections.singletonMap(FilterProperty.KLADR_ID, kladrId));
        return this;
    }

    public BankRequestBuilder status(OrganizationStatus status) {
        statuses.add(status);
        return this;
    }

    public BankRequestBuilder type(BankType type) {
        types.add(type);
        return this;
    }

    @Override
    public BankRequest build() {
        return new BankRequest(super.query, super.count, super.locationsBoost, locations, statuses, types);
    }
}
