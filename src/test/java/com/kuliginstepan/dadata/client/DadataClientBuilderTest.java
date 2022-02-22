package com.kuliginstepan.dadata.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

public class DadataClientBuilderTest {

    @Test
    public void shouldFailsWithoutToken() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new DadataClientBuilder().build());
    }

    @Test
    public void shouldFailsIncorrectProxy() {
        DadataClientProperties properties = new DadataClientProperties();
        properties.setToken(TestUtils.TOKEN);
        properties.setProxy(new DadataClientProperties.ProxyProperties());
        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> new DadataClientBuilder().clientProperties(properties).build());
    }

    @Test
    public void shouldUseProvidedWebClient() {
        WebClient webClient = WebClient.create();
        DadataClient client = new DadataClientBuilder().webClient(webClient).build();
        Object webClient1 = ReflectionTestUtils.getField(client, "webClient");
        assertThat(webClient).isEqualTo(webClient1);
    }
}