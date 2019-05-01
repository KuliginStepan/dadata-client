package com.kuliginstepan.dadata.client.domain.bank;

import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import java.util.Optional;
import org.springframework.core.ParameterizedTypeReference;

public class BankSuggestion implements SuggestionType<Bank> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Bank>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Bank>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/bank";
    }

    @Override
    public Optional<String> getFindByIdOperationPrefix() {
        return Optional.empty();
    }
}
