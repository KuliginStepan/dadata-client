package com.kuliginstepan.dadata.client.domain.bank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankSuggestionTest {

    private static final BankSuggestion SUGGESTION = new BankSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/bank", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFindByIdOperationPrefix() {
        SUGGESTION.getFindByIdOperationPrefix();
    }
}