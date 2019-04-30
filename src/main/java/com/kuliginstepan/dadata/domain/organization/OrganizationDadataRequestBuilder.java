package com.kuliginstepan.dadata.domain.organization;


import com.kuliginstepan.dadata.domain.DadataRequestBuilder;
import com.kuliginstepan.dadata.domain.OrganizationStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrganizationDadataRequestBuilder extends DadataRequestBuilder<OrganizationDadataRequest> {

    private List<Map<String, String>> locations = new ArrayList<>();
    private Set<OrganizationStatus> statuses = new HashSet<>();
    private OrganizationType type;
    private BranchType branchType;

    public static OrganizationDadataRequestBuilder create(String query) {
        return new OrganizationDadataRequestBuilder(query);
    }

    protected OrganizationDadataRequestBuilder(String query) {
        super(query);
    }

    public OrganizationDadataRequestBuilder location(String region) {
        locations.add(Collections.singletonMap("kladr_id", region));
        return this;
    }

    public OrganizationDadataRequestBuilder status(OrganizationStatus status){
        statuses.add(status);
        return this;
    }

    public OrganizationDadataRequestBuilder organizationType(OrganizationType type) {
        this.type = type;
        return this;
    }

    public OrganizationDadataRequestBuilder branchType(BranchType type) {
        branchType = type;
        return this;
    }

    @Override
    public OrganizationDadataRequest build() {
        return new OrganizationDadataRequest(super.query, super.locationsBoost, locations, statuses, type, branchType);
    }
}
