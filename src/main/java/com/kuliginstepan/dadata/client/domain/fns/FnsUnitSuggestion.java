package com.kuliginstepan.dadata.client.domain.fns;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class FnsUnitSuggestion implements SuggestionType<FnsUnit> {

    @Override
    public ParameterizedTypeReference<DadataResponse<FnsUnit>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<FnsUnit>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/fns_unit";
    }

}
