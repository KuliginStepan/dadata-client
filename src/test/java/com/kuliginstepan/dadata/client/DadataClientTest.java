package com.kuliginstepan.dadata.client;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import com.kuliginstepan.dadata.client.domain.fio.FioSuggestion;
import com.kuliginstepan.dadata.client.exception.DadataException;
import org.junit.jupiter.api.Test;

public class DadataClientTest {

    @Test
    public void clientWithBadTokenTest() {
        assertThatExceptionOfType(DadataException.class)
            .isThrownBy(() -> {
                DadataClient client = new DadataClientBuilder().token("123456").build();
                client.findAddressById("").block();
            });
    }

    @Test
    public void notSupportedOperationTest() {
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> TestUtils.CLIENT.findById(new FioSuggestion(), new BasicRequest("test")).block());
    }

}