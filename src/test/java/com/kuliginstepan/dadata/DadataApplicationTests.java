package com.kuliginstepan.dadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuliginstepan.dadata.domain.Suggestion;
import com.kuliginstepan.dadata.domain.address.Address;
import com.kuliginstepan.dadata.domain.address.AddressDadataRequestBuilder;
import com.kuliginstepan.dadata.domain.address.Bound;
import com.kuliginstepan.dadata.domain.fio.Fio;
import com.kuliginstepan.dadata.domain.fio.FioDadataRequestBuilder;
import com.kuliginstepan.dadata.domain.fio.FioPart;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class DadataApplicationTests {

    DadataClient client = new DadataClient("d0a06c568347cb09905d9a0fe9009380eb6b25d3");

    @Test
    public void fioSuggestionsTest() {
        List<Suggestion<Fio>> suggestions = client.suggestFio(FioDadataRequestBuilder.create("Виктор Иван").count(7).build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(7, suggestions.size());
    }

    @Test
    public void fioSuggestionsWithPartsTest() {
        List<Suggestion<Fio>> suggestions = client.suggestFio(FioDadataRequestBuilder.create("Викто").part(FioPart.NAME).build())
            .collectList().block();
        List<String> surnamesAndPatronymics = suggestions.stream()
            .flatMap(it -> Stream.of(it.getData().getSurname(), it.getData().getPatronymic()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertTrue(surnamesAndPatronymics.isEmpty());
    }

    @Test
    public void addressSuggestionsTest() {
        List<Suggestion<Address>> suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("москва серпуховская")
            .build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(10, suggestions.size());
    }

    @Test
    public void addressSuggestionsWithLocationsTest() {
        List<Suggestion<Address>> suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("Ватутина")
            .location("kladr_id", "65").build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        Assert.assertTrue(suggestions.get(0).getData().getRegionKladrId().startsWith("65"));
        assertEquals(1, suggestions.size());

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("московское шоссе")
            .location("city_fias_id", "110d6ad9-0b64-47cf-a2ee-7e935228799c").build()).collectList().block();

        List<String> cityFiasIds = suggestions.stream()
            .map(it -> it.getData().getCityFiasId())
            .distinct()
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, cityFiasIds.size());
        assertEquals("110d6ad9-0b64-47cf-a2ee-7e935228799c", cityFiasIds.get(0));
        assertEquals(10, suggestions.size());

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("Ботаническая")
            .location("region", "москва").build()).collectList().block();

        List<String> cityKladrIds = suggestions.stream()
            .map(it -> it.getData().getCityKladrId())
            .distinct()
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, cityKladrIds.size());
        assertTrue(cityKladrIds.get(0).startsWith("77"));
        assertEquals(2, suggestions.size());


        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("ростов рассветная")
            .location("region", "адыгея")
            .location("region", "астраханская")
            .location("region", "волгоградская")
            .location("region", "калмыкия")
            .location("region", "краснодарский")
            .location("region", "ростовская")
            .build()).collectList().block();

        List<String> regions = suggestions.stream()
            .map(it -> it.getData().getRegion())
            .distinct()
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, regions.size());
        assertEquals("Ростовская", regions.get(0));
        assertEquals(10, suggestions.size());

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("Абрикосовая")
            .location("region", "Самарская")
            .location("city", "Тольятти")
            .build()).collectList().block();

        regions = suggestions.stream()
            .map(it -> it.getData().getRegion())
            .distinct()
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, regions.size());
        assertEquals("Самарская", regions.get(0));
        assertEquals(10, suggestions.size());

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("Турчанинов")
            .location("region", "Москва")
            .restrictValue()
            .build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertFalse(suggestions.get(0).getValue().contains("Москва"));
        assertEquals(1, suggestions.size());

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("башко")
            .location("region_type_full", "республика")
            .build()).collectList().block();

        List<String> regionTypes = suggestions.stream()
            .map(it -> it.getData().getRegionType())
            .distinct()
            .collect(Collectors.toList());

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, regionTypes.size());
        assertEquals("респ", regionTypes.get(0));

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("берлин")
            .location("country", "*")
            .build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(10, suggestions.size());
    }

    @Test
    public void granularAddressSuggestionsTest() {
        List<Suggestion<Address>> suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("тур")
            .location("region", "москва")
            .fromBound(Bound.STREET)
            .toBound(Bound.STREET)
            .restrictValue()
            .build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(6, suggestions.size());

        suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("12")
            .location("street_fias_id", "dd08e4e2-82ff-43b5-81f7-93f59f013974")
            .fromBound(Bound.HOUSE)
            .restrictValue()
            .build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, suggestions.size());
        assertEquals("д 12", suggestions.get(0).getValue());
    }

    @Test
    public void rangingAddressSuggestionsTest() throws JsonProcessingException {
        List<Suggestion<Address>> suggestions = client.suggestAddress(AddressDadataRequestBuilder.create("невский")
            .location("kladr_id", "78")
            .location("kladr_id", "47")
            .build()).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals("Санкт-Петербург", suggestions.get(0).getData().getRegion());
        assertEquals("Ленинградская", suggestions.get(2).getData().getRegion());
        System.out.println(new ObjectMapper().writeValueAsString(AddressDadataRequestBuilder.create("невский")
            .location("kladr_id", "78")
            .location("kladr_id", "47")
            .build()));
    }

    @Test
    public void findAddressByIdTest() {
        Suggestion<Address> suggestion = client.findAddressById("5f96fd6b-b3de-451f-b280-8fedf859e683").block();
        System.out.println(suggestion);
    }
}
