package com.kuliginstepan.dadata.client;

import static com.kuliginstepan.dadata.client.TestUtils.CLIENT;
import static com.kuliginstepan.dadata.client.TestUtils.getDistinctList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.email.Email;
import java.util.List;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;

public class EmailSuggestionTest {

    @Test
    public void suggestEmailTest() {
        List<Suggestion<Email>> suggestions = CLIENT.suggestEmail(new BasicRequest("sacred_grove@", 7)).collectList()
            .block();
        List<String> locals = getDistinctList(it -> it.getData().getLocal(), suggestions);
        List<String> domain = getDistinctList(it -> it.getData().getDomain(), suggestions);

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(7, suggestions.size());
        assertEquals(1, locals.size());
        assertEquals("sacred_grove", locals.get(0));
        assertThat(domain, IsCollectionContaining.hasItems("mail.ru", "yandex.ru", "pochta.ru"));
    }
}
