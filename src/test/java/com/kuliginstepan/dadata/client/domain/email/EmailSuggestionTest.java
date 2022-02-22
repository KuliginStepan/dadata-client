package com.kuliginstepan.dadata.client.domain.email;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmailSuggestionTest {

    private static final EmailSuggestion SUGGESTION = new EmailSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/email", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test
    public void getFindByIdOperationPrefix() {
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(SUGGESTION::getFindByIdOperationPrefix);
    }
}