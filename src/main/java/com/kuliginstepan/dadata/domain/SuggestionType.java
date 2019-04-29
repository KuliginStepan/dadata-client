package com.kuliginstepan.dadata.domain;

import java.util.Optional;
import org.springframework.core.ParameterizedTypeReference;

public interface SuggestionType<T> {

    ParameterizedTypeReference<DadataResponse<T>> getResponseClass();

    String getSuggestOperationPrefix();

    default Optional<String> getFindByIdOperationPrefix() {
        return Optional.of(getSuggestOperationPrefix());
    };
}
