package com.kuliginstepan.dadata.client.domain.fms;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class FmsUnitSuggestion implements SuggestionType<FmsUnit> {

    @Override
    public ParameterizedTypeReference<DadataResponse<FmsUnit>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<FmsUnit>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/fms_unit";
    }

}
