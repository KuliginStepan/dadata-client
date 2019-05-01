package com.kuliginstepan.dadata.client.domain.bank;

import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Test;

public class BankSuggestionTest {

    private static final BankSuggestion SUGGESTION = new BankSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/bank", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test
    public void getFindByIdOperationPrefix() {
        assertEquals(Optional.empty(), SUGGESTION.getFindByIdOperationPrefix());
    }
}