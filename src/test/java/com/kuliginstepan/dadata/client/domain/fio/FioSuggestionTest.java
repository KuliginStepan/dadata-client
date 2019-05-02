package com.kuliginstepan.dadata.client.domain.fio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FioSuggestionTest {

    private static final FioSuggestion SUGGESTION = new FioSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/fio", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFindByIdOperationPrefix() {
        SUGGESTION.getFindByIdOperationPrefix();
    }
}