package com.kuliginstepan.dadata.client.domain.organization;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class OrganizationSuggestion implements SuggestionType<Organization> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Organization>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Organization>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/party";
    }
}
