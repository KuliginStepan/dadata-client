package com.kuliginstepan.dadata.client.domain.email;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class EmailSuggestion implements SuggestionType<Email> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Email>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Email>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/email";
    }

    @Override
    public String getFindByIdOperationPrefix() {
        throw new UnsupportedOperationException("Operation 'findById' not supported for Email");
    }
}
