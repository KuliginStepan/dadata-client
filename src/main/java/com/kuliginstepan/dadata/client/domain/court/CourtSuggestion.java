package com.kuliginstepan.dadata.client.domain.court;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class CourtSuggestion implements SuggestionType<Court> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Court>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Court>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/region_court";
    }

}
