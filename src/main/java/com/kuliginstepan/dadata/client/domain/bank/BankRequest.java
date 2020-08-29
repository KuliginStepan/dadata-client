package com.kuliginstepan.dadata.client.domain.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.client.domain.BasicRequest;
import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.domain.address.FilterProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669107">Dadata bank suggestion docs</a>
 * @see com.kuliginstepan.dadata.client.domain.bank.BankRequestBuilder
 */

@Value
@EqualsAndHashCode(callSuper = true)
public class BankRequest extends BasicRequest {

    @JsonProperty("locations_boost")
    List<Map<FilterProperty, String>> locationsBoost;
    List<Map<FilterProperty, String>> locations;
    @JsonProperty("status")
    Set<OrganizationStatus> statuses;
    @JsonProperty("type")
    Set<BankType> types;

    public BankRequest(String query, Integer count, List<Map<FilterProperty, String>> locationsBoost,
        List<Map<FilterProperty, String>> locations,
        Set<OrganizationStatus> statuses, Set<BankType> types) {
        super(query, count);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.statuses = statuses;
        this.types = types;
    }
}
