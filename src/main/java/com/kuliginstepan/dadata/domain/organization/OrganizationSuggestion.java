package com.kuliginstepan.dadata.domain.organization;

import com.kuliginstepan.dadata.domain.SuggestionType;
import com.kuliginstepan.dadata.domain.DadataResponse;
import org.springframework.core.ParameterizedTypeReference;

public class OrganizationSuggestion implements SuggestionType<Organization> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Organization>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Organization>>(){};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/party";
    }
}
