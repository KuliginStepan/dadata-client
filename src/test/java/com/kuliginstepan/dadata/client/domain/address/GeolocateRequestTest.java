package com.kuliginstepan.dadata.client.domain.address;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GeolocateRequestTest {

    @Test
    public void geolocateWithoutRadiusTest() {
        GeolocateRequest request = new GeolocateRequest(10, 20);
        assertEquals(10, request.getLat(), 1);
        assertEquals(20, request.getLon(), 1);
        assertEquals(100, request.getRadius());
    }

    @Test
    public void geolocateWithRadiusTest() {
        GeolocateRequest request = new GeolocateRequest(10, 20, 30);
        assertEquals(10, request.getLat(), 1);
        assertEquals(20, request.getLon(), 1);
        assertEquals(30, request.getRadius());
    }
}