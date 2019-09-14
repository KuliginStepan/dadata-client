package com.kuliginstepan.dadata.client.domain.fio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FioRequestBuilderTest {

    @Test
    public void fioRequestBuilderTest() {
        FioRequest request = FioRequestBuilder.create("test")
            .gender(Gender.FEMALE).build();

        assertEquals("test", request.getQuery());
        assertEquals(Gender.FEMALE, request.getGender());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void fioRequestBuilderWithLocationTest() {
        FioRequestBuilder.create("test").locationBoost("66").build();
    }
}