package com.kuliginstepan.dadata.client.domain.postal;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class PostalOfficeSuggestion implements SuggestionType<PostalOffice> {

    @Override
    public ParameterizedTypeReference<DadataResponse<PostalOffice>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<PostalOffice>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/postal_office";
    }

}
