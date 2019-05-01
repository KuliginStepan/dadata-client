package com.kuliginstepan.dadata.client;

import static com.kuliginstepan.dadata.client.TestUtils.getDistinctList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.bank.Bank;
import com.kuliginstepan.dadata.client.domain.bank.BankRequestBuilder;
import com.kuliginstepan.dadata.client.domain.bank.BankType;
import java.util.List;
import org.junit.Test;

public class BankSuggestionTest {


    @Test
    public void suggestBankTest() {
        List<Suggestion<Bank>> suggestions = TestUtils.CLIENT.suggestBank(BankRequestBuilder.create("альфа").build())
            .collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals("АЛЬФА-БАНК", suggestions.get(0).getValue());
    }

    @Test
    public void rangingSuggestBankTest() {
        List<Suggestion<Bank>> suggestions = TestUtils.CLIENT
            .suggestBank(BankRequestBuilder.create("сбербанк").locationBoost("4402400100000").build()).collectList()
            .block();
        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertTrue(suggestions.get(0).getData().getAddress().getData().getRegionKladrId().startsWith("44"));
    }

    @Test
    public void suggestBankWithLocationTest() {
        List<Suggestion<Bank>> suggestions = TestUtils.CLIENT
            .suggestBank(BankRequestBuilder.create("сбербанк").location("6100000100000").build()).collectList()
            .block();
        List<String> kladrIds = getDistinctList(it -> it.getData().getAddress().getData().getKladrId(), suggestions);
        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(1, kladrIds.size());
        assertTrue(kladrIds.get(0).startsWith("61"));
    }

    @Test
    public void suggestBankWithStatusTest() {
        List<Suggestion<Bank>> suggestions = TestUtils.CLIENT
            .suggestBank(BankRequestBuilder.create("мастер банк").status(OrganizationStatus.LIQUIDATED)
                .status(OrganizationStatus.LIQUIDATING).build()).collectList()
            .block();
        List<OrganizationStatus> statuses = getDistinctList(it -> it.getData().getState().getStatus(), suggestions);
        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertFalse(statuses.contains(OrganizationStatus.ACTIVE));
    }

    @Test
    public void suggestBankWithTypeTest() {
        List<Suggestion<Bank>> suggestions = TestUtils.CLIENT
            .suggestBank(BankRequestBuilder.create("сбербанк").type(BankType.BANK_BRANCH).type(BankType.BANK).build()).collectList()
            .block();
        List<BankType> types = getDistinctList(it -> it.getData().getOpf().getType(), suggestions);
        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals(2, types.size());
        assertTrue(types.contains(BankType.BANK));
        assertTrue(types.contains(BankType.BANK_BRANCH));
    }
}
