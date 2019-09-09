package com.kuliginstepan.dadata.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.delivery.Delivery;
import org.junit.Test;

public class DeliverySuggestionTest {

    @Test
    public void findDeliveryByIdTest() {
        Suggestion<Delivery> suggestion = TestUtils.CLIENT.findDeliveryById("3100400100000").block();

        assertNotNull(suggestion);

        Delivery delivery = suggestion.getData();
        assertEquals("01929", delivery.getBoxberryId());
        assertEquals("344", delivery.getCdekId());
        assertEquals("196006461", delivery.getDpdId());
    }


}
