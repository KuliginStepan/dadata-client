package com.kuliginstepan.dadata.domain.email;

import com.kuliginstepan.dadata.domain.SuggestionType;
import com.kuliginstepan.dadata.domain.DadataResponse;
import java.util.Optional;
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
    public Optional<String> getFindByIdOperationPrefix() {
        return Optional.empty();
    }
}
