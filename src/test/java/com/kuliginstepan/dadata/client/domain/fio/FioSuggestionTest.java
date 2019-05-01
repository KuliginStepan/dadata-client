package com.kuliginstepan.dadata.client.domain.fio;

import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Test;

public class FioSuggestionTest {

    private static final FioSuggestion SUGGESTION = new FioSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/fio", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test
    public void getFindByIdOperationPrefix() {
        assertEquals(Optional.empty(), SUGGESTION.getFindByIdOperationPrefix());
    }
}