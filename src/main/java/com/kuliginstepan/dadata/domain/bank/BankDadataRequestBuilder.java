package com.kuliginstepan.dadata.domain.bank;


import com.kuliginstepan.dadata.domain.DadataRequestBuilder;
import com.kuliginstepan.dadata.domain.OrganizationStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BankDadataRequestBuilder extends DadataRequestBuilder<BankDadataRequest> {

    private List<Map<String, String>> locations = new ArrayList<>();
    private Set<OrganizationStatus> statuses = new HashSet<>();
    private Set<BankType> types = new HashSet<>();

    public static BankDadataRequestBuilder create(String query) {
        return new BankDadataRequestBuilder(query);
    }

    protected BankDadataRequestBuilder(String query) {
        super(query);
    }

    public BankDadataRequestBuilder location(String kladrId) {
        locations.add(Collections.singletonMap("kladr_id", kladrId));
        return this;
    }

    public BankDadataRequestBuilder status(OrganizationStatus status) {
        statuses.add(status);
        return this;
    }

    public BankDadataRequestBuilder type(BankType type) {
        types.add(type);
        return this;
    }

    @Override
    public BankDadataRequest build() {
        return new BankDadataRequest(super.query, super.count, super.locationsBoost, locations, statuses, types);
    }
}
