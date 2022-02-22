package com.kuliginstepan.dadata.client;

import static com.kuliginstepan.dadata.client.TestUtils.CLIENT;
import static com.kuliginstepan.dadata.client.TestUtils.getDistinctList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.email.Email;
import java.util.List;
import org.hamcrest.core.IsIterableContaining;
import org.junit.jupiter.api.Test;

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
        assertThat(domain,
            IsIterableContaining.hasItems("mail.ru", "bk.ru", "list.ru", "inbox.ru", "gmail.com", "yandex.ru",
                "ya.ru"));
    }
}
