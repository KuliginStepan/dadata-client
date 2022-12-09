package com.kuliginstepan.dadata.client.domain.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BankSuggestionTest {

    private static final BankSuggestion SUGGESTION = new BankSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/bank", SUGGESTION.getSuggestOperationPrefix());
    }

}