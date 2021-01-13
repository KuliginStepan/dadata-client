package com.kuliginstepan.dadata.client;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.okpd2.Okpd2;
import org.junit.Test;

import java.util.List;

import static com.kuliginstepan.dadata.client.TestUtils.CLIENT;
import static org.junit.Assert.*;

public class Okpd2SuggestionTest {

    @Test
    public void findOkpd2ByCodeTest() {
        Suggestion<Okpd2> okpd2 = CLIENT
                .findOkpd2ByCode("14.11.10").block();

        assertEquals("C", okpd2.getData().getRazdel());
        assertEquals("C.14.11.10", okpd2.getData().getIdx());
    }

    @Test
    public void suggestOkpd2ByCodeTest() {
        List<Suggestion<Okpd2>> suggestions = CLIENT
                .suggestOkpd2(new BasicRequest("14.11.10.11")).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(7, suggestions.size());
    }

    @Test
    public void suggestOkpd2ByTitleTest() {
        List<Suggestion<Okpd2>> suggestions = CLIENT
                .suggestOkpd2(new BasicRequest("Пальто и плащи мужские из кожи")).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, suggestions.size());
        assertEquals("14.11.10.111", suggestions.get(0).getData().getKod());
    }
}
