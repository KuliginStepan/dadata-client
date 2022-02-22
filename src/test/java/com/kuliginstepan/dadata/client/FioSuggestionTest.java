package com.kuliginstepan.dadata.client;

import static com.kuliginstepan.dadata.client.TestUtils.CLIENT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.fio.Fio;
import com.kuliginstepan.dadata.client.domain.fio.FioPart;
import com.kuliginstepan.dadata.client.domain.fio.FioRequestBuilder;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class FioSuggestionTest {

    @Test
    public void suggestFioTest() {
        List<Suggestion<Fio>> suggestions = CLIENT.suggestFio(FioRequestBuilder.create("Виктор Иван").count(7).build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(7, suggestions.size());
    }

    @Test
    public void suggestFioWithPartsTest() {
        List<Suggestion<Fio>> suggestions = CLIENT
            .suggestFio(FioRequestBuilder.create("Викто").part(FioPart.NAME).build())
            .collectList().block();
        List<String> surnamesAndPatronymics = suggestions.stream()
            .flatMap(it -> Stream.of(it.getData().getSurname(), it.getData().getPatronymic()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertTrue(surnamesAndPatronymics.isEmpty());
    }
}
