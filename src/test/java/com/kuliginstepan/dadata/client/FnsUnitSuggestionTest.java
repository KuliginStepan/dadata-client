package com.kuliginstepan.dadata.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.fns.FnsUnit;
import com.kuliginstepan.dadata.client.domain.fns.FnsUnitRequest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FnsUnitSuggestionTest {

    @Test
    public void suggestFnsUnitTest() {
        List<Suggestion<FnsUnit>> suggestions = TestUtils.CLIENT.suggestFnsUnit(
            FnsUnitRequest.builder()
                .query("ленинск")
                .build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());

        FnsUnit fnsUnit = suggestions.get(0).getData();
        assertNotNull(fnsUnit.getCode());
        assertNotNull(fnsUnit.getName());
        assertNotNull(fnsUnit.getInn());
    }

    @Test
    public void suggestFnsUnitWithFilterTest() {
        List<Suggestion<FnsUnit>> suggestions = TestUtils.CLIENT.suggestFnsUnit(
            FnsUnitRequest.builder()
                .query("ленинск")
                .regionCode("58")
                .build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());

        suggestions.forEach(suggestion -> assertTrue(suggestion.getData().getCode().startsWith("58")));
    }

    @Test
    public void findFnsUnitByIdTest() {
        Suggestion<FnsUnit> suggestion = TestUtils.CLIENT.findFnsUnitById("5836").block();

        assertNotNull(suggestion);

        FnsUnit fnsUnit = suggestion.getData();
        assertEquals("5836", fnsUnit.getCode());
        assertEquals("5836010018", fnsUnit.getInn());
    }


}
