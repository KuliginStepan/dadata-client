package com.kuliginstepan.dadata.client.domain.email;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmailSuggestionTest {

    private static final EmailSuggestion SUGGESTION = new EmailSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/email", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFindByIdOperationPrefix() {
        SUGGESTION.getFindByIdOperationPrefix();
    }
}