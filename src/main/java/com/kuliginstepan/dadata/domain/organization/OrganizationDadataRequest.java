package com.kuliginstepan.dadata.domain.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.domain.DadataRequest;
import com.kuliginstepan.dadata.domain.OrganizationStatus;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;

@Getter
public class OrganizationDadataRequest extends DadataRequest {

    @JsonProperty("locations_boost")
    private List<Map<String, String>> locationsBoost;
    private List<Map<String, String>> locations;
    @JsonProperty("status")
    private Set<OrganizationStatus> statuses;
    private OrganizationType type;
    @JsonProperty("branch_type")
    private BranchType branchType;

    public OrganizationDadataRequest(String query,
        List<Map<String, String>> locationsBoost,
        List<Map<String, String>> locations, Set<OrganizationStatus> statuses,
        OrganizationType type, BranchType branchType) {
        super(query);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.statuses = statuses;
        this.type = type;
        this.branchType = branchType;
    }
}
