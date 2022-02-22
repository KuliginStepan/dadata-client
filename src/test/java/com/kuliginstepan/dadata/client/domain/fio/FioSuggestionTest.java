package com.kuliginstepan.dadata.client.domain.fio;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FioSuggestionTest {

    private static final FioSuggestion SUGGESTION = new FioSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/fio", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test
    public void getFindByIdOperationPrefix() {
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(SUGGESTION::getFindByIdOperationPrefix);
    }
}