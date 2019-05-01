package com.kuliginstepan.dadata.client;

import static com.kuliginstepan.dadata.client.TestUtils.CLIENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.address.GeolocateRequest;
import java.util.List;
import org.junit.Test;

public class GeolocateRequestTest {

    @Test
    public void geolocateTest() {
        List<Suggestion<Address>> suggestions = CLIENT.geolocate(new GeolocateRequest(55.601983, 37.359486, 50)).collectList().block();

        assertNotNull(suggestions);
        assertFalse(suggestions.isEmpty());
        assertEquals("г Москва, пгт Московский, ул Бианки, д 4 к 2", suggestions.get(0).getValue());
    }
}
