package com.kuliginstepan.dadata.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.postal.PostalOffice;
import com.kuliginstepan.dadata.client.domain.postal.PostalOfficeFilter;
import com.kuliginstepan.dadata.client.domain.postal.PostalOfficeRequest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PostalOfficeSuggestionTest {

    @Test
    public void suggestPostalOfficeTest() {
        List<Suggestion<PostalOffice>> suggestions = TestUtils.CLIENT.suggestPostalOffice(
            PostalOfficeRequest.builder()
                .query("32")
                .build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());

        PostalOffice office = suggestions.get(0).getData();
        assertNotNull(office.getIndex());
        assertNotNull(office.getOpsname());
        assertNotNull(office.getOpstype());
    }

    @Test
    public void suggestPostalOfficeWithFilterTest() {
        List<Suggestion<PostalOffice>> suggestions = TestUtils.CLIENT.suggestPostalOffice(
            PostalOfficeRequest.builder()
                .query("32")
                .filter(PostalOfficeFilter.builder()
                    .region("Самарская область")
                    .city("Самара")
                    .build())
                .build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());

        suggestions.stream()
            .map(Suggestion::getData).forEach(office -> {
            assertTrue(office.getIndex().contains("32"));
            assertTrue(office.getCity().equalsIgnoreCase("Самара"));
            assertTrue(office.getRegion().equalsIgnoreCase("Самарская область"));
        });
    }

    @Test
    public void findFmsUnitByIdTest() {
        Suggestion<PostalOffice> suggestion = TestUtils.CLIENT.findPostalOfficeById("157505").block();

        assertNotNull(suggestion);

        PostalOffice office = suggestion.getData();
        assertEquals("157505", office.getIndex());
        assertEquals("ШАРЬЯ", office.getCity());
    }


}
