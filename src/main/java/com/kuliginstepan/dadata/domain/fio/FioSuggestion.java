package com.kuliginstepan.dadata.domain.fio;

import com.kuliginstepan.dadata.domain.SuggestionType;
import com.kuliginstepan.dadata.domain.DadataResponse;
import java.util.Optional;
import org.springframework.core.ParameterizedTypeReference;

public class FioSuggestion implements SuggestionType<Fio> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Fio>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Fio>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/fio";
    }

    @Override
    public Optional<String> getFindByIdOperationPrefix() {
        return Optional.empty();
    }
}
