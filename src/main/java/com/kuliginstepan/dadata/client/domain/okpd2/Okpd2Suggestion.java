package com.kuliginstepan.dadata.client.domain.okpd2;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class Okpd2Suggestion implements SuggestionType<Okpd2> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Okpd2>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Okpd2>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/okpd2";
    }

}
