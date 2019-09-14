package com.kuliginstepan.dadata.client.domain.organization;


import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.domain.RequestBuilder;
import com.kuliginstepan.dadata.client.domain.address.FilterProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrganizationRequestBuilder extends RequestBuilder<OrganizationRequest> {

    private List<Map<FilterProperty, String>> locations = new ArrayList<>();
    private Set<OrganizationStatus> statuses = EnumSet.allOf(OrganizationStatus.class);
    private OrganizationType type;
    private BranchType branchType;

    public static OrganizationRequestBuilder create(String query) {
        return new OrganizationRequestBuilder(query);
    }

    protected OrganizationRequestBuilder(String query) {
        super(query);
    }

    public OrganizationRequestBuilder location(String region) {
        locations.add(Collections.singletonMap(FilterProperty.KLADR_ID, region));
        return this;
    }

    public OrganizationRequestBuilder status(OrganizationStatus status) {
        statuses.add(status);
        return this;
    }

    public OrganizationRequestBuilder organizationType(OrganizationType type) {
        this.type = type;
        return this;
    }

    public OrganizationRequestBuilder branchType(BranchType type) {
        branchType = type;
        return this;
    }

    @Override
    public OrganizationRequest build() {
        return new OrganizationRequest(super.query, super.count, super.locationsBoost, locations, statuses, type,
            branchType);
    }
}
