package com.kuliginstepan.dadata.domain.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.domain.DadataRequest;
import com.kuliginstepan.dadata.domain.OrganizationStatus;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;

@Getter
public class BankDadataRequest extends DadataRequest {

    @JsonProperty("locations_boost")
    private List<Map<String, String>> locationsBoost;
    private List<Map<String, String>> locations;
    @JsonProperty("status")
    private Set<OrganizationStatus> statuses;
    @JsonProperty("type")
    private Set<BankType> types;

    public BankDadataRequest(String query, Integer count, List<Map<String, String>> locationsBoost,
        List<Map<String, String>> locations,
        Set<OrganizationStatus> statuses, Set<BankType> types) {
        super(query, count);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.statuses = statuses;
        this.types = types;
    }
}
