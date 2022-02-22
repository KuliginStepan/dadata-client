package com.kuliginstepan.dadata.client.domain.fio;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FioRequestBuilderTest {

    @Test
    public void fioRequestBuilderTest() {
        FioRequest request = FioRequestBuilder.create("test")
            .gender(Gender.FEMALE).build();

        assertEquals("test", request.getQuery());
        assertEquals(Gender.FEMALE, request.getGender());
    }

    @Test
    public void fioRequestBuilderWithLocationTest() {
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> FioRequestBuilder.create("test").locationBoost("66").build());
    }
}