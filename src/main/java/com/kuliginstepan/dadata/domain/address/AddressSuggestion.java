package com.kuliginstepan.dadata.domain.address;

import com.kuliginstepan.dadata.domain.SuggestionType;
import com.kuliginstepan.dadata.domain.DadataResponse;
import org.springframework.core.ParameterizedTypeReference;

public class AddressSuggestion implements SuggestionType<Address> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Address>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Address>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/address";
    }
}
