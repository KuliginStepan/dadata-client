package com.kuliginstepan.dadata.client.domain.email;

import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Test;

public class EmailSuggestionTest {

    private static final EmailSuggestion SUGGESTION = new EmailSuggestion();

    @Test
    public void getSuggestOperationPrefix() {
        assertEquals("/email", SUGGESTION.getSuggestOperationPrefix());
    }

    @Test
    public void getFindByIdOperationPrefix() {
        assertEquals(Optional.empty(), SUGGESTION.getFindByIdOperationPrefix());
    }
}