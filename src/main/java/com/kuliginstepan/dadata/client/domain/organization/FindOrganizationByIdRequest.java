package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.client.domain.BasicRequest;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Request accoring to <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=568918058">parameters</a>
 */
@EqualsAndHashCode(callSuper = true)
@Value
public class FindOrganizationByIdRequest extends BasicRequest {

    @JsonProperty("branch_type")
    private final String branchType;
    private final String kpp;
    private final String type;

    @Builder
    public FindOrganizationByIdRequest(String query, String branchType, String kpp, String type) {
        super(query);
        this.branchType = branchType;
        this.kpp = kpp;
        this.type = type;
    }
}
